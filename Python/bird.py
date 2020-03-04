import urllib.request
from xml.etree.ElementTree import Element, SubElement, tostring
from xml.dom import minidom
import re

finding = ''
web_url = 'https://www.allaboutbirds.org/guide/Western_Gull'

web_url = input("Input a url: ")

with urllib.request.urlopen(web_url) as response:
    for line in response:
        line = line.decode('utf-8')
        if('Basic Description' in line):
            name = (line.split('<h4>')[1].split('</h')[0])
            desc = (line.split('</h5><p>')[1].split('</p>')[0])
            if('Find This Bird' in line):
                finding = (line.split('<p><p>')[1].split('</p>')[0])
            habitat = (line.split('Habitat</span><span>')[1].split('</span>')[0])
            diet = (line.split('Food</span><span>')[1].split('</span>')[0])
            nest = (line.split('Nesting</span><span>')[1].split('</span>')[0])
            behavior = (line.split('Behavior</span><span>')[1].split('</span>')[0])
            conservation = (line.split('Conservation</span><span>')[1].split('</span>')[0])

if(web_url.endswith('overview') or web_url.endswith('overview/')):
    web_url.replace('overview', 'id')
elif(web_url.endswith('/')):
    web_url += 'id'
else:
    web_url += '/id'

with urllib.request.urlopen(web_url) as response:
    for line in response:
        line = line.decode('utf-8')
        if('Relative Size' in line):
            shape_search = re.search("<article><p>([\w,.'\-(); ]*)</p>", line)
            if(shape_search != None):
                print(shape_search.group(1))
            size_search = re.search("Relative Size</h5><p>([\w,.'\-(); ]*)</p>", line)
            if(size_search == None or len(size_search.group(1)) < 1):
                size_search = re.search("<span>([\w,.'\-(); ]*)</span><h5>Measurements", line)
            print(size_search.group(1))
            #print(line)

print('\n\n~~~\n\n')

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
