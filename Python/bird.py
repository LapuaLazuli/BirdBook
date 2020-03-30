import urllib.request
from xml.etree.ElementTree import Element, SubElement, tostring
from xml.dom import minidom
import re
import sqlite3

# I do not use this anymore but I will keep the code here
## creates an XML file of all the bird info
def create_xml(name, desc, finding, habitat, diet, nest, behavior, conservation):
    top = Element('Bird_List')

    name_child = SubElement(top, 'bird')
    name_child.set('name', name)

    desc_child = SubElement(name_child, 'description')
    desc_child.text = desc

    if(finding != ''):
        finding_child = SubElement(name_child, 'finding')
        finding_child.text = finding

    habitat_child = SubElement(name_child, 'habitat')
    habitat_child.text = habitat

    diet_child = SubElement(name_child, 'diet')
    diet_child.text = diet

    nest_child = SubElement(name_child, 'nest')
    nest_child.text = nest

    behavior_child = SubElement(name_child, 'behavior')
    behavior_child.text = behavior

    conservation_child = SubElement(name_child, 'conservation')
    conservation_child.text = conservation

    rough_string = tostring(top, 'utf-8')
    reparsed = minidom.parseString(rough_string)
    print(reparsed.toprettyxml(indent='\t', newl='\n'))


conn = sqlite3.connect('bird.db')
conn.execute('''CREATE TABLE birds
                (name text,
                description text,
                size text,
                shape text,
                finding text,
                habitat text,
                diet text,
                nest text,
                behavior text,
                conservation text)''')
bird_arr = []

# Sometimes trying to access the webpage returns a 403 bad gateway
## you can fake headers by passing an extra argument to urllib.request.Request
hdr = {'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11',
       'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
       'Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3',
       'Accept-Encoding': 'none',
       'Accept-Language': 'en-US,en;q=0.8',
       'Connection': 'keep-alive'}

while(1):
    name = input("Input a bird name: ")
    if(name == ''):
        break
    name = name.capitalize()
    
    web_url = 'https://www.allaboutbirds.org/guide/' + name.replace(' ', '_')

    finding = ''
    shape = ''
    try:
        overview_page = urllib.request.Request(web_url,None,hdr)
        response = urllib.request.urlopen(overview_page)
        line = response.read()
        line = line.decode('utf-8')
        desc = (line.split('</h5><p>')[1].split('</p>')[0])
        if('Find This Bird' in line):
            finding = (line.split('<p><p>')[1].split('</p>')[0])
        habitat = (line.split('Habitat</span><span>')[1].split('</span>')[0])
        diet = (line.split('Food</span><span>')[1].split('</span>')[0])
        nest = (line.split('Nesting</span><span>')[1].split('</span>')[0])
        behavior = (line.split('Behavior</span><span>')[1].split('</span>')[0])
        conservation = (line.split('Conservation</span><span>')[1].split('</span>')[0])

        if(web_url.endswith('overview') or web_url.endswith('overview/')):
            web_url.replace('/overview', '')
        if(not web_url.endswith('/')):
            web_url+= '/'
        web_url += 'id'
        
        id_page = urllib.request.Request(web_url,None,hdr)
        response2 = urllib.request.urlopen(id_page)
        line = response2.read()
        line = line.decode('utf-8')
        if('Relative Size' in line):
            shape_search = re.search("<article><p>([\w,.'\-(); ]*)</p>", line)
            if(shape_search != None):
                shape = (shape_search.group(1))
            size_search = re.search("Relative Size</h5><p>([\w,.'\-(); ]*)</p>", line)
            if(size_search == None or len(size_search.group(1)) < 1):
                size_search = re.search("<span>([\w,.'\-(); ]*)</span><h5>Measurements", line)
            size = (size_search.group(1))
        bird_arr.append((name, desc, size, shape, finding, habitat, diet, nest, behavior, conservation))

    except urllib.error.HTTPError:
        print('Bad url')
    
    

#print('\n\n~~~\n\n')
#create_xml(name, desc, finding, habitat, diet, nest, behavior, conservation)

# Put our array into the file, save it, and close it
conn.executemany("INSERT INTO birds VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", bird_arr)
conn.commit()
conn.close()
