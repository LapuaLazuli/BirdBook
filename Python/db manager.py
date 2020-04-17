import sqlite3

conn = sqlite3.connect('bird.db')
cur = conn.cursor()
for row in conn.execute('SELECT * FROM birds'):
    print(row[0].lower().replace(' ', '_') + '.jpg')
    command = 'UPDATE birds set image_path = ? where name= ?'
    data = (row[0].lower().replace(' ', '_') + '.jpg', row[0])
    cur.execute(command, data)
    command = 'UPDATE birds set audio_path = ? where name= ?'
    data = (row[0].lower().replace(' ', '_') + '.mp3', row[0])
    cur.execute(command, data)

conn.commit()
cur.close()
conn.close()
