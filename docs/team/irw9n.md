# irw9n - Project Portfolio Page

## Project: Quotely

Quotely is a lightweight CLI application for creating and exporting quotations. It supports storing quotes and items, computing totals (including tax), and exporting a printable PDF of a quote.

### Summary of Contributions

- Code contributed: [tp code dashboard](https://nus-cs2113-ay2526s1.github.io/tp-dashboard/?search=&sort=groupTitle&sortWithin=title&timeframe=commit&mergegroup=&groupSelect=groupByRepos&breakdown=true&checkedFileTypes=docs~functional-code~test-code~other&since=2025-09-19T00%3A00%3A00&filteredFileName=&tabOpen=true&tabType=authorship&tabAuthor=irw9n&tabRepo=AY2526S1-CS2113-W10-1%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code&authorshipIsBinaryFileTypeChecked=false&authorshipIsIgnoredFilesChecked=false)

#### Enhancements implemented:  
- Added NavigateCommand & CalculateTotal command
- Added tax attribute to all items along with methods to access & modify tax rates
- Ensured tax handling was done in post v1.0 iterations for CalculateTotal command
- Added NavigateCommand anf CalculateTotal command tests
- Parser: Added maximum item count, item price, item quantity, item tax rate for PE-D fix
- Parser: Added parseNavigateCommand, parseCalculateTotalCommand
- Exceptions: Added corresponding exceptions for error-handling

#### Contributions to team-based tasks:
- Contributed to the User Stories
- Attend discussion during weekly team meetings and brainstorm weekly Todos and issues

#### Review/mentoring contributions:
- Link to PRs reviewed [here](https://github.com/AY2526S1-CS2113-W10-1/tp/pulls?q=is%3Apr+is%3Aclosed+reviewed-by%3Airw9n).

<div style="page-break-after: always;"></div>

#### Contribution to the User Guide:
- Added modification to sections involving tax rate changes
- Added FAQ questions and answers on FAQ page

<div style="page-break-after: always;"></div>

#### Contribution to the Developer Guide: 
- hasTax & tax-handling feature
- Sequence Diagrams in 'Design' section and 'hasTax & tax-handling' feature section 
for an example of component interaction when the user adds one quote, and
  then add one item to that quote.
- Added Instructions for Manual Testing
