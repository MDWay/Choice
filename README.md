# Choice
Choice is an esoteric programming language designed for golfing purposes.

## Overall structure
### Comment
A line comment starts with `\`. The line counting continues anyway. You may not call this line, but it's name is reserved any. If the `main` function does not contain any code or is commented out, nothing is executed.
### Function naming
Each line is function. The first function is the `main()` function. The next if `f()`, `g()`, `h()`, ..., `m()`. We get later why it stops there. After `m()` the functions are accessable via `?<number after m>`. Example:
```
main()
f()
g()
h()
...
m()
?<1>()
?<2>()
?<3>()
```
### Parameter / Function header
If a variable is used anywhere in the function it is automatically added to the function header. The variable name range is from `n` to `v`. 
### Function body
The function body consist of either a statement or an infinite amount of equations and export statements.
#### Single statement
A mathematical statement without a `=`. The result is automatical exported.
```
\main
2n
nn
nnn
n^4
n^n
```
In this example the function `f(n)` is defined which exports `2*n`. The function `g(n)` exports `n*n` or `n^2`, `h(n)` exports `n*n*n` or `n^3`, `i(n)` exports `n^4` and so on.
Other commands can be found in the (not existing) operator list.
#### Equations
Equations or export statements can be seperated `;`. If you want to write an export statement you than you have to replace that `;` with a `:`.
Export statements define what is returned. You can have one export statement per function. If you have an export statment all variables or values are export as an array. Example:
```
\main
:2n1op
2v=n:v1
vv=n:v
vv=nn:v
```
The function `f()` has no arguments since all variables are in the export statment. If they are defined to any value anywhere else in the program the values are exported as `[2,n,1,o,p]`. The function `g(n)` has no `v` as parameter since it is used in the export statement. This functions first defines `v` as the half of `n` if there are more rules later in the program the value is used that fulfills all rules. If there is no matching value `null` is exported instead. If there are more possible values it is wrapped in an array and exported after that. Example: `i2` (shorthand for `i(2)`) exports `[-2,2]`. There is a variable that is pre-exported: `$`
Example: 
```
\main
$n=100
```
In this case you could rewrite `f(n)` to `n/100`.
#### Calling functions
To call a function with an single argument you can use `<name><arg>`:
```
f2
100n
```
will result in `main` exporting `200`.
If a function has more than one argument you have to use `{}`'s to wrap the arguments (space-separated):
```
f21
g{2 n}
2no
```
First `main` calls `f` with `n=21` and exports the result. Then `f` calls `g` with `n=2` and `o=21` and exports the result. Than `g` multipies `2` with `n=2` and `o=21` resulting in `g`, `f` and `main` exporting `84`.
