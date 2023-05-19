var ctx = document.getElementById('myChart').getContext('2d');
var  postive = document.getElementById('PositiveData').value;
var  negative = document.getElementById('NegativeData').value;
var  recovered = document.getElementById('RecoveredData').value;
var myChart = new Chart(ctx, {
    type: 'polarArea',
    data: {
        labels: ['PositiveCases', 'NegativeCases','RecoveredCases','DeathCases'],
        datasets: [{
            label: '# Covid-19Cases',
            data: [postive, negative,recovered,1500],
            backgroundColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth: 0
        }]
    },
    options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});
 var barChart = new Chart(Earnings, {
    type: 'bar',
    data: {
        labels: ['PositiveCases', 'NegativeCases','RecoveredCases','DeathCases'],
        datasets: [{
            label: '#Covid-19Cases',
            data: [postive, negative, recovered,negative ],
            backgroundColor: [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderColor: [
                'rgba(255, 99, 132,1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
                'rgba(153, 102, 255, 1)',
                'rgba(255, 159, 64, 1)'
            ],
            borderWidth:0
        }]
    },
 options: {
        scales: {
            y: {
                beginAtZero: true
            }
        }
    }
});