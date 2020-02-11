# BusCompany
A bus company requires an automatic system for booking. All available routes are contained in a text file. A route has a source city,
a destination city, the departure and the arrival times, the total available number of seats and the price for one ticket.
When the application starts each client has a window allowing them to choose the source city(from a list of a combo box). The destination city
lis will be automatically updated to contain only the cities reachable from the selected source city.
After the client chooses the source and destination cities, a new list will show all the available routes, with the following information:
source city,destination city,departure and arrival time, duration and ticket price.
A client can select the desired route and book a given number of tickets. The total price will be shown in the client's window.
An administrator window will show all bookings. This will be updated automatically, as clients make their bookings. Bookings will be shown 
sorted by departure city and by departure time. Use Java stream for this sorting.
Create 2 cients and allow them to make bookings.
