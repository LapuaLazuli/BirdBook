import urllib.request
import re
import wget
import os
import sqlite3

conn = sqlite3.connect('bird.db')

header = {'User-Agent': 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.64 Safari/537.11',
       'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
       'Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.3',
       'Accept-Encoding': 'none',
       'Accept-Language': 'en-US,en;q=0.8',
       'Connection': 'keep-alive'}

for row in conn.execute('SELECT name FROM birds'):
    web_url = 'https://www.allaboutbirds.org/guide/' + row[0].lower().replace(' ', '_') + '/'
    print(web_url)
    line = ''

    try:
        overview_page = urllib.request.Request(web_url, None, header)
        response = urllib.request.urlopen(overview_page)
        line = response.read()
        line = line.decode('utf-8')
        
    except urllib.error.HTTPError:
        print('bad url')

    bird_picture_search = re.search("([0-9]*)-720px\.jpg", line)
    bird_picture = 'https://www.allaboutbirds.org/guide/assets/photo/' + bird_picture_search.group(1) + '.jpg'
    print(bird_picture)

    bird_call_search = re.search("([0-9]*)\.mp3", line)
    bird_call = 'https://www.allaboutbirds.org/guide/assets/sound/' + bird_call_search.group(1) + '.mp3'
    print(bird_call)


    try:
        wget.download(bird_picture, os.getcwd() + row[0].lower().replace(' ', '_') + '.jpg')
        wget.download(bird_call, os.getcwd() + row[0].lower().replace(' ', '_') + '.mp3')
        print(row[0] + ' complete')
    except urllib.error.HTTPError:
        print(row[0] + ' failed')


conn.close()
