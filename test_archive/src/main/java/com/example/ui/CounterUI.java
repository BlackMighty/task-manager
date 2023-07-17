package com.example.ui;

import com.example.Service.CounterService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("")
public class CounterUI extends VerticalLayout {

    private final CounterService counterService;
    private final IntegerField counterField;

    @Autowired
    public CounterUI(CounterService counterService) {
        this.counterService = counterService;

        counterField = new IntegerField("Counter");
        counterField.setReadOnly(false);
        counterField.setMin(0);
        add(counterField);

        Button incrementButton = new Button("Increment");
        incrementButton.addClickListener(e -> incrementCounter());
        add(incrementButton);

        VerticalLayout mainLayout = new VerticalLayout(); // Создаем новую компоновку
        add(mainLayout); // Добавляем новую компоновку в вертикальную компоновку CounterUI
    }

    private void incrementCounter() {
        int currentValue = counterField.getValue();
        counterService.incrementCounterValue(1);
        int updatedValue = counterService.getCounterValue();
        counterField.setValue(updatedValue);
        Notification.show("Counter incremented! Current value: " + updatedValue);
    }
}
