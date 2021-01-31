# Orders

This is a Scala CLI tool to check if older products are still being sold. 
Given a time range and an optional set of month intervals it outputs the number of orders that have products with that given age.
For example: 

```
1-3 months: 200 orders
4-6 months: 150 orders``
7-12 months: 50 orders
>12 months: 20 orders
```
# Building
To build the application use:
 ```
sbt assembly
```
The file orders.jar will be generated at `./target/scala-2.13/orders.jar`.

It can be used as:

```java -jar ./target/scala-2.13/orders.jar -s "2020-01-01 00:00:00" -e "2021-01-01 00:00:00```
 
 
# Usage
```
Orders 0.1
Usage: Orders [options]

  -s, --start <value>      start is a datetime with the following pattern: yyyy-MM-dd HH:mm:ss
  -e, --end <value>        end is a datetime with the following pattern: yyyy-MM-dd HH:mm:ss
  -i, --intervals <value>  interval is an array of ranges, g.e. 1-3,4-6,7-12,>12
```