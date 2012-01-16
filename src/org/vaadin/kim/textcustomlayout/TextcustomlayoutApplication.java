package org.vaadin.kim.textcustomlayout;

import org.vaadin.kim.textcustomlayout.TextCustomLayout.LocationClickEvent;
import org.vaadin.kim.textcustomlayout.TextCustomLayout.LocationClickEvent.LocationClickListener;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;

public class TextcustomlayoutApplication extends Application implements
        LocationClickListener {

    int i = 0;

    @Override
    public void init() {
        setTheme("test");

        Window mainWindow = new Window("Textcustomlayout Application");
        Label label = new Label("Hello Vaadin user");
        setMainWindow(mainWindow);

        final TextCustomLayout layout = new TextCustomLayout("test");
        layout.addText("this is some text", "first");
        layout.addComponent(label, "second");
        layout.addListener(this, "first");

        Button button = new Button("Switch", new ClickListener() {

            public void buttonClick(ClickEvent event) {
                layout.addText("foobar " + i, i % 2 == 0 ? "second" : "first");
                layout.addComponent(new Label("wtf " + i), i % 2 == 0 ? "first"
                        : "second");
                i++;
            }
        });

        mainWindow.addComponent(layout);
        mainWindow.addComponent(button);
    }

    public void locationClicked(LocationClickEvent event) {
        getMainWindow().showNotification(event.getLocation());
    }

}
