<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Performance Page</title>
   <style>
    /* Table Styles */
    table {
        border-collapse: collapse;
        width: 100%;
    }
    
    th, td {
        padding: 12px;
        text-align: left;
        border: 1px solid #ccc;
    }
    
    th {
        background-color: #f2f2f2;
        font-weight: bold;
        cursor: pointer;
        position: relative;
        user-select: none;
    }
    
    th.sortable::after {
        content: '';
        position: absolute;
        top: 50%;
        right: 10px;
        transform: translateY(-50%);
        width: 0;
        height: 0;
        border-style: solid;
        border-width: 6px 4px 0 4px;
    }
    
    th.asc::after {
        border-color: transparent transparent #ffcc00 transparent;
    }
    
    th.desc::after {
        border-color: #007bff transparent transparent transparent;
    }
    
    .performance-row:hover {
        background-color: #f5f5f5;
        cursor: pointer;
    }
    
    /* Text Styles */
    body {
        font-family: Arial, sans-serif;
        font-size: 14px;
        color: #333333;
        line-height: 1.5;
    }
    
    h1 {
        text-align: center;
        font-size: 24px;
        font-weight: bold;
        margin-bottom: 30px;
    }
    
    /* Header Styles */
    .header {
        background-color: #333333;
        color: #ffffff;
        padding: 10px;
    }
    
    .header h2 {
        margin: 0;
        font-size: 18px;
        font-weight: bold;
    }
    
    /* Table Body Styles */
    .table-body {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }
    
    /* Table Responsive Styles */
    .table-responsive {
        overflow-x: auto;
    }
    
    /* Table Cell Styles */
    .cell-center {
        text-align: center;
    }
    
    .cell-right {
        text-align: right;
    }
    
    /* Table Row Styles */
    .row-even {
        background-color: #f2f2f2;
    }
    
    /* Performance Score Styles */
    .performance-score {
        font-weight: bold;
        text-align: center;
        padding: 6px;
        border-radius: 3px;
        font-size: 16px;
    }
    
    .performance-high {
        background-color: rgba(102, 187, 106, 0.2); /* Light green */
        color: #333333;
    }
    
    .performance-medium {
        background-color: rgba(255, 183, 77, 0.2); /* Light orange */
        color: #333333;
    }
    
    .performance-low {
        background-color: rgba(239, 83, 80, 0.2); /* Light red */
        color: #333333;
    }
    
    /* Pagination Styles */
    .pagination {
        margin-top: 20px;
        text-align: center;
    }
    
    .pagination a {
        display: inline-block;
        padding: 6px 10px;
        background-color: #f2f2f2;
        color: #333333;
        text-decoration: none;
        border-radius: 3px;
        margin-right: 5px;
    }
    
    .pagination a.active {
        background-color: #007bff;
        color: #ffffff;
    }
    
    /* Responsive Styles */
    @media screen and (max-width: 768px) {
        table {
            font-size: 12px;
        }
    
        .header {
            padding: 8px;
        }
    
        .header h2 {
            font-size: 16px;
        }
    
        .performance-score {
            font-size: 14px;
        }
    
        .pagination a {
            padding: 4px 8px;
        }
    }
</style>

    <script>
        function sortTable(columnIndex) {
            let table = document.getElementById("performance-table");
            let headerRow = table.rows[0];
            let clickedColumn = headerRow.cells[columnIndex];
            let sortingClass = clickedColumn.classList.contains('asc') ? 'desc' : 'asc';

            resetSortingClasses();
            clickedColumn.classList.add(sortingClass);

            let rows = Array.from(table.rows).slice(1);

            rows.sort(function(a, b) {
                let x = a.cells[columnIndex].innerHTML.toLowerCase();
                let y = b.cells[columnIndex].innerHTML.toLowerCase();
                if (!isNaN(x) && !isNaN(y)) {
                    x = parseFloat(x);
                    y = parseFloat(y);
                }
                if (x > y) {
                    return sortingClass === 'asc' ? 1 : -1;
                } else if (x < y) {
                    return sortingClass === 'asc' ? -1 : 1;
                }
                return 0;
            });

            for (let i = 0; i < rows.length; i++) {
                table.appendChild(rows[i]);
            }
        }

        function resetSortingClasses() {
            let table = document.getElementById("performance-table");
            let headerRow = table.rows[0];
            let headerCells = headerRow.cells;

            for (let i = 0; i < headerCells.length; i++) {
                headerCells[i].classList.remove('asc', 'desc');
            }
        }
    </script>
</head>
<body>
    <h1>Resource Performance</h1>
    <table id="performance-table">
        <tr>
            <th onclick="sortTable(0);" class="sortable">Resource Name<span class="arrow"></span></th>
            <th onclick="sortTable(1);" class="sortable">Performance Score<span class="arrow"></span></th>
            <th onclick="sortTable(2);" class="sortable">Hours Worked<span class="arrow"></span></th>
            <th onclick="sortTable(3);" class="sortable">Tasks Completed<span class="arrow"></span></th>
            <th onclick="sortTable(4);" class="sortable">Total Tasks<span class="arrow"></span></th>
        </tr>
        <c:forEach items="${resources}" var="resource">
            <tr class="performance-row">
                <td>${resource.userDisplayName}</td>
              <td class="performance-score ${resource.performanceScore >= 70 ? 'performance-high' : (resource.performanceScore >= 50 ? 'performance-medium' : 'performance-low')}">${resource.performanceScore}</td>

                <td>${resource.hoursWorked}</td>
                <td>${resource.tasksCompleted}</td>
                <td>${resource.totalTasks}</td>
            </tr>
        </c:forEach>
    </table>

    <script>
        function getPerformanceClass(score) {
            let performanceScore = parseFloat(score);
            if (performanceScore >= 70) {
                return 'performance-high';
            } else if (performanceScore >= 50) {
                return 'performance-medium';
            } else {
                return 'performance-low';
            }
        }
    </script>
</body>
</html>
