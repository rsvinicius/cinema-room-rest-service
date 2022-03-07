# Cinema Room REST Service

Always wanted to have your private movie theater and screen only the movies you like? You can buy a fancy projector and set it up in a garage, but how can you sell tickets? This simple Spring REST service will help you manage a small movie theatre.

## Requirements

- Java 11+
- IntelliJ IDEA / Netbeans / Eclipse

## Usage 

Start application in IDE or via command line:

```
./gradlew bootRun
```

**Default port**: 28852

## Endpoints

### GET: /seats/
Returns the information about the cinema seats.

### POST: /purchase/
Allow customers to purchase tickets

**Request body example**: 
```
{
"row": 9,
"column": 7
}
```

### POST: /return/
Allow customers to refund their tickets

**Request body example**:
```
{
"token": "b65faeb5-b12c-47fc-871a-e1a9252c4533"
}
```

### POST: /stats/?password={{password}}
Show movie theater statistics

**Query param**: password

**Default password**: super_secret

## Possible improvements

As all applications this one can also be improved. Possible improvements:

- Include database to store cinema room information such as:
    - Available seats
    - Bought seats
- Allow multiple cinema rooms
- Include service tests
- Remove or change the **stats endpoint** variable password from source code to an external config file
    
## Contributing 

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.  Please make sure to update tests as appropriate.

## License

Usage is provided under the [MIT License](https://mit-license.org/). See LICENSE for full details.
