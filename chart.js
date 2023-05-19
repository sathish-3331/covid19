var ctx = document.getElementById('myChart').getContext('2d');
var Earnings= document.getElementById('Earnings').getContext('2d');
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
var  male = document.getElementById('MaleData').value;
var  Female = document.getElementById('FemaleData').value;
var xValues = ["Male","Female","others"];
var barColorsdoughnut = [
 'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(75, 192, 192, 1)',
      ];
new Chart("newChart", {
  type: "doughnut",
  data: {
    labels: xValues,
    datasets: [{
      backgroundColor: barColorsdoughnut,
      data: [male, Female, 1],
    }]
  },
  options: {
    title: {
      display: true,
      text: "World Wide Wine Production 2018"
    }
  }
});
var  age15t025 = document.getElementById('age').value;
var  age25to45 = document.getElementById('age1').value;
var  age45to70 = document.getElementById('age2').value;
var  age70to90 = document.getElementById('age3').value;
var  age90to110 = document.getElementById('age4').value;
var ageValues = ["age15t025","age25to45","age45to70","age70to90","age90to110"];
var barColors = [
                'rgba(255, 99, 132, 1)',
                'rgba(54, 162, 235, 1)',
                'rgba(255, 206, 86, 1)',
                'rgba(70, 192, 172, 3)',
                'rgba(255, 99, 71, 0.8)',];
new Chart("newChart1", {
  type: "doughnut",
  data: {
    labels: ageValues,
    datasets: [{
      backgroundColor: barColors,
      data: [5, 9, 10],
    }]
  },
  options: {
    title: {
      display: true,
      text: "World Wide Wine Production 2018"
    }
  }
});
