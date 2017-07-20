# [CS111B] 2017.07.18

### Panel

```java
Panel pnl = new Panel();          // Panel is a container
Button btn = new Button("Press"); // Button is a component
pnl.add(btn);                     // The Panel container adds a Button component
```

### Label

```java
// CONSTRUCTORS
public Label(String strLabel, int alignment); // Construct a Label with the given text String, of the text alignment
public Label(String strLabel);                // Construct a Label with the given text String
public Label();                               // Construct an initially empty Label

// CONSTANTS
public static final LEFT;    // Label.LEFT
public static final RIGHT;   // Label.RIGHT
public static final CENTER;  // Label.CENTER

// EXAMPLES
public String getText();
public void setText(String strLabel);
public int getAlignment();
public void setAlignment(int alignment);

Label lblInput;                     // Declare an Label instance called lblInput
lblInput = new Label("Enter ID");   // Construct by invoking a constructor via the new operator
add(lblInput);                      // this.add(lblInput) - "this" is typically a subclass of Frame
lblInput.setText("Enter password"); // Modify the Label's text string
lblInput.getText();                 // Retrieve the Label's text string
```

### Button

```java
// CONSTRUCTORS
public Button(String btnLabel);     // Construct a Button with the given label
public Button();                    // Construct a Button with empty label

// PUBLIC METHODS
public String getLabel();                   // Get the label of this Button instance
public void setLabel(String btnLabel);      // Set the label of this Button instance
public void setEnable(boolean enable);      // Enable or disable this Button. Disabled Button cannot be clicked.
```
