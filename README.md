# MaintenanceMonitor
Maintenance Monitor 

Implementing the Maintenance Monitor based on specifications. 

The green screen will only show if the word “running” is found in data/MonitorStatus.txt file. 
An empty file or any other word will return a red screen
POST message can be used to modify the status:

http://localhost:8080/api/monitor/mode/{message}
Example: http://localhost:8080/api/monitor/mode/running


POST method to reset the status (use Boolean true / false): 

http://localhost:8080/api/monitor/reset/{reset}
Example: http://localhost:8080/api/monitor/reset/true