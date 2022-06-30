Feature: Search Flights

Scenario: Check flight availability
Given User is on Allegiant Landing page
When User search flights with_locations, date and ticket count
Then Select fllight page should be displayed
And flights are displayed