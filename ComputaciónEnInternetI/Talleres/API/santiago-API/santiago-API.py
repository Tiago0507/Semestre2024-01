import urllib.parse
import requests

main_api = "https://www.mapquestapi.com/directions/v2/route?"
orig = "Cali, CO"
dest = "Palmira, CO"


#Se usa la llave obtenida del sitio developer de Mapquest
key = "S5QBdzNi6AtLvUfVdRTf5XRsrhn6LyYM"
url = main_api + urllib.parse.urlencode({"key": key, "from": orig, "to": dest})
json_data = requests.get(url).json()
print("URL: " + (url))
#Variable que ayuda a filtrar el contenido del json_data
json_status = json_data["info"]["statuscode"]

#Podemos hacer uso de un for loop para poder filtrar la información narrativa la cual nos 
#dará direcciones de el cómo llegar a nuestro destino.
if json_status == 0:
    print("API Status: " + str(json_status) + " = A successful route call.\n")
    print("Trip Duration: " + (json_data["route"]["formattedTime"]))
    print("Miles: " + str(json_data["route"]["fuelUsed"]))
    print("Fuel Used (Gal): " + str(json_data["route"]["fuelUsed"]))
    for each in json_data["route"]["legs"][0]["maneuvers"]:
        print((each["narrative"]) + " (" + str("{:.2f}".format((each["distance"])) + " km)"))