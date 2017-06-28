# [CS111B] 2017.06.26

### String

* `char[] toCharArray()` converts a string to an array of characters
* Strings are immutable
* if you are manipulating strings a lot, you'd be better off using `StringBuilder`
* `StringBuilder` and `StringBuffer` are similar, but `StringBuffer` is synchronized
* `StringBuilder sb = new Stringuilder()`
* `StringBuilder sb = new Stringuilder(String string)`
* you can chain methods to make them more consise
* **anonymous object**, **anonymous array**, **anonymous class** - creation of an object/array/class without assigning it to a variable (in memory) - immediately goes to garbage collection
    ```java
    (new StringBuilder(string)).reverse()
    ```
* **lambda**s were created to overcome the complexities of anonymous classes
* filter method

### Character

* represents `char`
* "is" methods: all `static boolean`
    * `isLetter(char c)`
    * `isDigit(char c)`
    * `isUpper(char c)`
    * `isLower(char c)`
    * `isWhitespace(char c)`
    * `isISOControl(char c)` - control characters: tab, spacebar, fn, alt, etc.
    * `isLetterOrDigit(char c)` - alphanumeric

    ```java
    input = input.toUpperCase();
    char[] c = input.toCharArray();
    String str = "";

    for(char x : c)
    {
        if ((x <= 'A' && x <= 'Z') || (x >= '0' && x <= '9'))
        {
            str += c;
        }
    }

    return str;
    ```

    ```java
    input = input.toUpperCase();
    char[] c = input.toCharArray();
    String str = "";

    for(char x : c)
    {
        if (Character.isUpper(x) || Character.isDigit(x)) str += c;
    }

    return str;
    ```

    ```java
    input = input.toUpperCase();
    char[] c = input.toCharArray();
    String str = "";

    for(char x : input.toCharArray())
    {
        if (Character.isUpper(x) || Character.isDigit(x)) str += c;
    }

    return str;
    ```

    ```java
    String str = "";

    for(char x : input.toCharArray())
    {
        if (Character.isLetterOrDigit(x)) str += c;
    }

    return str.toUpperCase;
    ```
