function getWeather() {
    const apiKey = '351d61186eae89656b4aa420a8e29673'; // Reemplazar con su llave
    const city = document.getElementById('city-input').value; // Reemplazar con la ciudad deseada
	const language = document.getElementById('language-input').value;
    const units = document.getElementById('select-unity').value; 

    if (!city || !language) {
        alert('Por favor, ingrese una ciudad y un idioma.');
        return;
    }

    const apiUrl = `https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}&lang=${language}&units=${units}`;

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error('Error de red');
            }
            return response.json();
        })
        .then(data => {
            const weatherDiv = document.getElementById('weather');
            const temperature = units === 'metric' ? `${data.main.temp} °C` : `${data.main.temp} °F`;
            weatherDiv.innerHTML = `
                <h2>Tiempo en ${data.name}</h2>
                <p>Temperatura: ${temperature}</p>
                <p>Condiciones: ${data.weather[0].description}</p>
            `;
        })
        .catch(error => {
            console.error('Problema con fetch:', error);
    });
}
