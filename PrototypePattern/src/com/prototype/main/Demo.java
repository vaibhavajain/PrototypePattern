package com.prototype.main;

import java.util.ArrayList;
import java.util.List;

import com.prototype.common.Shape;
import com.prototype.concrete.Circle;
import com.prototype.concrete.Rectangle;

public class Demo {

	public static void main(String[] args) {
		List<Shape> shapes = new ArrayList<>();
		List<Shape> shapesCopy = new ArrayList<>();

		Circle circle = new Circle();
		circle.x = 10;
		circle.y = 20;
		circle.radius = 15;
		circle.color = "red";
		shapes.add(circle);

		Circle anotherCircle = (Circle) circle.clone();
		anotherCircle.color = "green";
		anotherCircle.x=1; // will not affect the previous one because of deep cloning
		shapes.add(anotherCircle);
		
		Circle thirdCircle = anotherCircle;
		thirdCircle.x=99; // will affect the previous one because of shallow cloning
		thirdCircle.color = "violet";
		shapes.add(thirdCircle);
		
		Rectangle rectangle = new Rectangle();
		rectangle.width = 10;
		rectangle.height = 20;
		rectangle.color = "blue";
		shapes.add(rectangle);

		cloneAndCompare(shapes, shapesCopy);
	}

	private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
		for (Shape shape : shapes) {
			shapesCopy.add(shape.clone());
		}

		for (int i = 0; i < shapes.size(); i++) {
			System.err.println(shapes.get(i).x + ", Color: " + shapes.get(i).color);
			if (shapes.get(i) != shapesCopy.get(i)) {
				System.out.println(i + ": Shapes are different objects (yay!)");
				if (shapes.get(i).equals(shapesCopy.get(i))) {
					System.out.println(i + ": And they are identical (yay!)");
				} else {
					System.out.println(i + ": But they are not identical (booo!)");
				}
			} else {
				System.out.println(i + ": Shape objects are the same (booo!)");
			}
		}
	}
}
