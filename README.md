# kitchenManagementApp
web app for simplifying kitchen management

##INTRO
This web app will allow kitchen managers to simplify their work load, and provide all the
    information to their staff members

##ROLES
1. chef - The chef role is the kitchen manager/chef
2. lineCook - The lineCook role will be the line cook staff
3. dishwasher - The dishwasher role will be the dishwasher staff
4. generalManager - The generalManager role will be the General Manager of the establishment

##WALK THROUGH

###Logging In
1. User will click the log in button for a drop down menu displaying roles, and click appropriate role
2. User will enter their user name and password, which will direct them to the appropriate landing page for their role

###Chef
1. The Chef landing page will have the ability to go to a page to add or to manage employees
    a. Add
        1. If the user is added successfully, a "Success" message will appear.  NOTE: as of 12/14/15 there is no form validation
    b. Manage
        1. Update
        2. Delete
            a. A modal will appear, where the chef can select a user, and click delete; User will no longer have access to app.  NOTE: Working on some cleaning up some issues with deleting a user and their role if the ID numbers are not identical
    c. Recipe Upload
        1. User can browse for a file to upload NOTE: as of 12/14/15, format MUST be a pdf
        2. User will select a name for the file, and a category NOTE: currently, this information is not used
        3. After file is uploaded, user can select "View Recipes" to view a list of links that will direct to a new tab that displays the recipe
    d. Schedule
        1. Currently unavailable
        
###General Manager
No Content available
1. Goals
    a. view list of employee contact information
    b. Add/Manage users
    
###Line Cook
No Content available
1. Goals
    a. view list of employee contact information
    b. view uploaded recipes
    c. update their password
    d. update their contact information
        
###Dishwaser
No Content available
1. Goals
    a. view list of employee contact information        
