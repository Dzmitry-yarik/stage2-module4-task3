package com.mjc.stage2.impl;

import com.mjc.stage2.Observer;
import com.mjc.stage2.entity.Rectangle;
import com.mjc.stage2.entity.RectangleValues;
import com.mjc.stage2.event.RectangleEvent;
import com.mjc.stage2.warehouse.RectangleWarehouse;

public class RectangleObserver implements Observer {
    @Override
    public void handleEvent(RectangleEvent event) {
        //getSource() - возвращает ссылку на объект, от которого пришло событие
        Rectangle rectangle = event.getSource();
        //ищем площать и периметр
        double square = rectangle.getSideA() * rectangle.getSideB();
        double perimeter = 2*(rectangle.getSideA() + rectangle.getSideB());
        //добавляем их в новый rectangleValues
        RectangleValues rectangleValues = new RectangleValues(square, perimeter);
        RectangleWarehouse rectangleWarehouse = RectangleWarehouse.getInstance();
        //создаем новый RectangleWarehouse
        rectangleWarehouse.put(rectangle.getId(),rectangleValues);
    }
}
