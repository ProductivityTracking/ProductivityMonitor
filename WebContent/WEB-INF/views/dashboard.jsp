<!DOCTYPE html>
<html>
<head>
  <title>Overall Project Analytics</title>
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
  <h1>Overall Project Analytics</h1>
  <div class="chart-container">
    <div class="chart">
      <h3>Task & Sub-Tasks Overview - (past 30 days progress)</h3>
      <canvas id="stackedBarChart"></canvas>
    </div>
  </div>
  <div class="chart-container">
    <div class="chart">
      <h3>Project Metrics - Radar Chart</h3>
      <canvas id="radarChart"></canvas>
    </div>
  </div>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
    $(document).ready(function() {
      $.ajax({
        url: 'getDashboardAnalytics',
        method: 'POST',
        dataType: 'json',
        success: function(response) {
          var completedDates = response.map(function(item) {
            return item.completedDate;
          });

          var tasksCompletedData = response.map(function(item) {
            return item.tasksCompleted;
          });

          var subtasksCompletedData = response.map(function(item) {
            return item.subtasksCompleted;
          });

          if (completedDates.length > 0) {
            var stackedBarCtx = document.getElementById('stackedBarChart').getContext('2d');
            var stackedBarChart = new Chart(stackedBarCtx, {
              type: 'bar',
              data: {
                labels: completedDates,
                datasets: [
                  {
                    label: 'Tasks Completed',
                    data: tasksCompletedData,
                    backgroundColor: 'rgba(54, 162, 235, 0.5)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1.5
                  },
                  {
                    label: 'Subtasks Completed',
                    data: subtasksCompletedData,
                    backgroundColor: 'rgba(255, 99, 132, 0.5)',
                    borderColor: 'rgba(255, 99, 132, 1)',
                    borderWidth: 1.5
                  }
                ]
              },
              options: {
                scales: {
                  x: {
                    stacked: true
                  },
                  y: {
                    stacked: true
                  }
                }
              }
            });
          } else {
            // Handle the case when no data is retrieved or completedDates is empty
            var stackedBarChart = new Chart(document.getElementById('stackedBarChart'), {});
            // Display a message or perform any other appropriate action
          }

          var radarCtx = document.getElementById('radarChart').getContext('2d');
          var radarChart = new Chart(radarCtx, {
            type: 'radar',
            data: {
              labels: ['Metric 1', 'Metric 2', 'Metric 3', 'Metric 4', 'Metric 5'],
              datasets: [
                {
                  label: 'Project Metrics',
                  data: [4, 5, 3, 2, 4],
                  backgroundColor: 'rgba(75, 192, 192, 0.5)',
                  borderColor: 'rgba(75, 192, 192, 1)',
                  borderWidth: 1.5
                }
              ]
            },
            options: {}
          });
        },
        error: function() {
          // Handle the AJAX error, display an error message, or perform any other appropriate action
        }
      });
    });
  </script>

  <style>
    .chart-container {
      display: flex;
      margin-bottom: 20px;
    }

    .chart {
      flex: 1;
      padding: 20px;
    }

    .chart canvas {
      width: 80%;
      height: 300px;
    }
  </style>
</body>
</html>
