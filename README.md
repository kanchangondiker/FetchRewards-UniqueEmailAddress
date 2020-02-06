# FetchRewards-UniqueEmailAddress
A web service that takes in a list of email addresses and returns an integer indicating the number of unique email addresses where "unique" email addresses means they will be delivered to the same account using Gmail account matching specifically Gmail will ignore the placement of "." in the username and it will ignore any portion of the username after a "+".

## Visuals


## Usage
Examples:
test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.
