async function getWeatherForecast(city, language) {
    const apiKey = '351d61186eae89656b4aa420a8e29673'; // Reemplazar con su llave
    const apiUrl = `https://api.openweathermap.org/data/2.5/forecast?q=${city}&units=metric&appid=${apiKey}`
    const response = await fetch(apiUrl);
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    const data = await response.json();
    return data;
}

function plotForecast(data) {
    const ctx = document.getElementById('forecastChart').getContext('2d');
    const labels = [];
    const temperatures = [];
    
    // Extract the temperature data for the next 24 hours (8 time points as the forecast is in 3-hour intervals)
    for (let i = 0; i < 8; i++) {
        const forecast = data.list[i];
        const date = new Date(forecast.dt * 1000);
        labels.push(`${date.getHours()}:00`);
        temperatures.push(forecast.main.temp);
    }

    new Chart(ctx, {
        type: 'line',
        data: {
            labels: labels,
            datasets: [{
                label: 'Temperatura (°C)',
                data: temperatures,
                borderColor: 'rgba(75, 192, 192, 1)',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                fill: true,
            }]
        },
        options: {
            scales: {
                x: {
                    title: {
                        display: true,
                        text: 'Tiempo'
                    }
                },
                y: {
                    title: {
                        display: true,
                        text: 'Temperatura (°C)'
                    }
                }
            }
        }
    });
}

async function main() {
    const city = document.getElementById('city-input').value;
    const language = document.getElementById('language-input').value;

    if (!city || !language) {
        alert('Por favor, ingrese una ciudad y un idioma.');
        return;
    }

    try {
        const forecastData = await getWeatherForecast(city, language);
        plotForecast(forecastData);
    } catch (error) {
        console.error('Se presentó un problema con la operación fetch:', error);
    }
}

// main();
