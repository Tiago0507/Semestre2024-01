grep -v Species $1 | cut -d , -f 2 | sort | uniq -c | grep -v 1
#### $1 es el primer argumento $2 el segundo, etc
