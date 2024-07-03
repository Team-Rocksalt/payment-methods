# Coding tasks for _payment-methods_ application

* Before proceeding on the implementation of the tasks below, please make sure you checked the contents of `README.md`;
* ask any question to interviewers in case a task or something else is not very clear;
* checking external sources (e.g., Google, Stackoverflow, etc) is allowed but please inform the interviewers when a
consulting is happening;
* usage of a 3rd-party/utility library is allowed: please justify the usage of such with interviewers;
* if you identify a code that can be somehow improved, inform the interviewers and add a // TODO note close to the code
* remember: your goal is to provide a workable, correct and clean solution.

## Task 1 - fix the bug

_Problem_: `GET /payment-methods` endpoint has a bug.

**Task**: Identify and fix the bug. Existing unit test code is correct and when the bug is fixed, the test will pass. 
Please fix the bug explain the root cause of it and the reason your fix works.

## Task 2 - add a filter

_Problem_: The endpoint `GET /payment-methods` returns a list of all payment methods. It should now be modified so that
the returned list of payment methods are filtered based on an optionally given country code.

Note: as the country code is optional, this endpoint should still return all the payment methods when no country code
is provided.

### Example
Suppose that database already contains the following entries:

| id | name      | country_code | country_default |
|----|-----------|--------------|-----------------|
| 1  | PAYPAL    | FR           | true            |
| 2  | VISA      | FR           | true            |
| 3  | APPLE_PAY | ES           | true            |
| 4  | VISA      | DE           | true            |

* A request for `GET /payment-methods` for country code `FR` should return the first two rows;
* A request for country code `ES` should return the 3rd row;
* A request without specific country code should return all rows. 

**Task**: Propose the REST API contract for the changes described above and implement it. 

## Task 3 - duplication prevention

_Problem_: The endpoint `POST /payment-methods` adds a new payment method. However, the current implementation violates
some constraints, like allowing same payment method to be added for the same country.

**Task**: Fix the problem by not allowing a duplicate payment method for same country to be added. Propose what could 
be the ideal response for this API endpoint in case a request for a duplication is received.

## Task 4 - country default constraint

_Problem_: Adding a new payment method via endpoint `POST /payment-methods` should now work reasonably fine. 
However, some of the country default payment method constraints are still being violated. 

**Task**: Make sure that country default payment method constraints 1 and 2 are enforced.

## Task 5 - deletion of a payment method

_Problem_: The endpoint `DELETE /payment-methods` is not yet implemented. Our PO requested us to make this functionality
ready and available.

**Task 5.1**: Implement the API endpoint accordingly.

**Task 5.2**: Make sure that country default constraints 3 is enforced.

## Task 6 - modify a payment method

_Problem_: Current API does not allow for the modification of a payment method. For instance, there is no way to change
the country default payment method (besides via adding/deletion).

**Task**: Implement a new API endpoint to modify the country default payment method for a country.

## Task 7 - country restriction

_Problem_: Currently, our application imposes no restriction on the country code that can be informed while adding a 
new payment method.

**Task**: Discuss possible solution(s) on how the problem can be resolved. Modify the application so that only 
persisted countries can be informed while adding a new payment method.

## Task 8 - payment method report

_Problem_: Our PO requested us to create a new API endpoint that outputs a report in .csv format of all payment methods.
The .csv should follows the tabular format below:

| Country name  | Payment Method name | Default |
|---------------|---------------------|---------|
| France        | PAYPAL              | Yes     |
| Germany       | APPLE_PAY           | Yes     |
| Germany       | VISA                | No      |

**Task**: Discuss possible solution(s) on how the problem can be resolved. Implement a new API endpoint providing 
the functionality that matches the requirement described above.

# Hints

## cURL cheat sheet

Below is a cheat sheet in case a REST client is not available:

### GET
> curl GET "URL"
### POST
> curl -X POST "URL" \
-H "Content-Type: application/json" \
-d "{ \
    \"KEY1\": \"VALUE1\", \
    \"KEY2\": \"VALUE2\", \
    \"KEY3_BOOLEAN\": boolean_value \
    }"
### DELETE
> curl -X DELETE "URL"