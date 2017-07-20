# [CS111B] 2017.07.19

### TextField

* `TextField(int numChar)`
* `TextField(String placeholder)`
* `TextField(String placeholder, int numChar)`

* `String [TextField].getText()`
* `void [TextField].setText(String text)`
* `String [TextField].getSelectedText()`
* `void [TextField].select(int startIndex, int endIndex)`
* `void [TextField].setEditable(boolean isEditable)`
* `boolean [TextField].isEditable(boolean isEditable)`
* `void [TextField].setEchoChar(int charCode)` - hides characters
* `boolean [TextField].echCharIsSet()` - hides characters
* `char [TextField].getEchoChar()` - hides characters

* See `[DemoTextField.java]`

### GridLayout

* See `[DemoGridLayout.java]`

### Checkbox

* `Checkbox()`
* `Checkbox(String string, boolean checked)`
* `Checkbox(String string, boolean checked, CheckboxGroup group)` --> creates radio buttons
* `Checkbox(String string, CheckboxGroup group, boolean checked)` --> creates radio buttons
* `boolean [Checkbox].getState()`
* `void [Checkbox].setState(boolean checked)`
* `String [Checkbox].getLabel()`
* `void [Checkbox].setLabel(String labelText)`
