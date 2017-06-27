# [CS111B] 2017.06.22

***Chapter***

### Random Notes

* to delete a set of files based on RegEx:
    * `ls | grep -P "[PATTERN]" | xargs -d"\n" rm`
    * `find [DIRECTORY]/ -name '[PATTERN]' -delete`
* https://stackoverflow.com/questions/8680344/why-new-keyword-not-needed-for-string
* you CANNOT redeclare variables within the same scope:
    ```java
        int i = 0;
        int i = 10;
        // WILL ERROR
    ```

### String

* `String` is an object, NOT a primitive
* `String`s use `""`, `char`s use `''`
* the name of the class `String` that comes with a variety of constructors
    * `String t = "Today is cold";`
    * `String u = new String("Today is cold");`
        ```
        char c[] = {'h', 'e', 'l', 'l', 'o'}
        String m = new String(c);
        ```
* `charAt(index)`
* `length()`
* `equals(string)`
* `equalsIgnoreCase(string)`
* `substring(firstIndexInclusive, oneBeyondTheLastIndexYouWantExclusive)` - if you seek outside the bounds, this will error, so you you just run `substring(startingIndex)` and Java will go all the way to the end
* `indexOf(string/char, startFromIndex)`
* `lastIndexOf(string/char)`
* `replace(searchString, newString)`
* `trim(string)` - strips **leading** and **trailing** **whitespace** (space, tab \t, carriage return \r, line feed \f, newline \n); has no effect on **embedded whitespace**
* `toUppercase()`
* `toLowercase()`
* `isEmpty()`
* `join()` concatenates - `String t = String.join(' ', 'I', 'like', 'Java') //=> "I like Java"`
* `split()` into array

## Homework Assignment 2

* `palindrome` - a word that is the same in both directions
    * ignore:
        * whitespace
        * punctuation
        * case
    * digits count
* determine if a given word/sentence/phrase is a palindrome or not
* interactive until exit case
