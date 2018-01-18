package Graphics3d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.plaf.synth.SynthSpinnerUI;

import com.apple.eawt.event.RotationEvent;

import javafx.application.Application;
import javafx.collections.ObservableFloatArray;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.RotateEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.DrawMode;
import javafx.scene.shape.MeshView;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class Cubic extends Application {
	static Group root = new Group();
	static Scene scene = new Scene(root, 400, 400);
	static int[] blank = { 72, 73, 74, 75 };

	static float[] points = new float[] {
			// array stores all the points coordinates
			0, 0, 300, // P0
			300, 0, 300, // P1
			0, 300, 300, // P2
			300, 300, 300, // P3
			0, 0, 0, // P4
			300, 0, 0, // P5
			0, 300, 0, // P6
			300, 300, 0, // P7
			0, 100, 300, // P8
			0, 200, 300, // P9
			100, 0, 300, // P10
			100, 100, 300, // P11
			100, 200, 300, // P12
			100, 300, 300, // P13
			200, 0, 300, // P14
			200, 100, 300, // P15
			200, 200, 300, // P16
			200, 300, 300, // P17
			300, 100, 300, // P18
			300, 200, 300, // P19
			300, 0, 200, // P20
			300, 100, 200, // P21
			300, 200, 200, // P22
			300, 300, 200, // P23
			300, 0, 100, // P24
			300, 100, 100, // P25
			300, 200, 100, // P26
			300, 300, 100, // P27
			300, 100, 0, // P28
			300, 200, 0, // P29
			0, 0, 200, // P30
			100, 0, 200, // P31
			200, 0, 200, // P32
			0, 0, 100, // P33
			100, 0, 100, // P34
			200, 0, 100, // P35
			100, 0, 0, // P36
			200, 0, 0, // P37
			0, 100, 200, // P38
			0, 200, 200, // P39
			0, 300, 200, // P40
			0, 100, 100, // P41
			0, 200, 100, // P42
			0, 300, 100, // P43
			0, 100, 0, // P44
			0, 200, 0, // P45
			100, 100, 0, // P46
			100, 200, 0, // P47
			100, 300, 0, // P48
			200, 100, 0, // P49
			200, 200, 0, // P50
			200, 300, 0, // P51
			100, 300, 200, // P52
			100, 300, 100, // P53
			200, 300, 200, // P54
			200, 300, 100,// P55
	};
	static int[] faces = new int[] {
			// array stores all the orders and arrangements between textures and points
			36, 1, 4, 0, 33, 2, //
			36, 1, 33, 2, 34, 3, //
			37, 5, 36, 4, 34, 6, //
			37, 5, 34, 6, 35, 7, //
			5, 9, 37, 8, 35, 10, //
			5, 9, 35, 10, 24, 11, //
			34, 13, 33, 12, 30, 14, //
			34, 13, 30, 14, 31, 15, //
			35, 17, 34, 16, 31, 18, //
			35, 17, 31, 18, 32, 19, //
			24, 21, 35, 20, 32, 22, //
			24, 21, 32, 22, 20, 23, //
			31, 25, 30, 24, 0, 26, //
			31, 25, 0, 26, 10, 27, //
			32, 29, 31, 28, 10, 30, //
			32, 29, 10, 30, 14, 31, //
			20, 33, 32, 32, 14, 34, //
			20, 33, 14, 34, 1, 35, //

			33, 37, 4, 36, 44, 38, //
			33, 37, 44, 38, 41, 39, //
			30, 41, 33, 40, 41, 42, //
			30, 41, 41, 42, 38, 43, //
			0, 45, 30, 44, 38, 46, //
			0, 45, 38, 46, 8, 47, //
			10, 73, 0, 72, 8, 74, //
			10, 73, 8, 74, 11, 75, //
			14, 77, 10, 76, 11, 78, //
			14, 77, 11, 78, 15, 79, //
			1, 81, 14, 80, 15, 82, //
			1, 81, 15, 82, 18, 83, //
			20, 109, 1, 108, 18, 110, //
			20, 109, 18, 110, 21, 111, //
			24, 113, 20, 112, 21, 114, //
			24, 113, 21, 114, 25, 115, //
			5, 117, 24, 116, 25, 118, //
			5, 117, 25, 118, 28, 119, //
			37, 145, 5, 144, 28, 146, //
			37, 145, 28, 146, 49, 147, //
			36, 149, 37, 148, 49, 150, //
			36, 149, 49, 150, 46, 151, //
			4, 153, 36, 152, 46, 154, //
			4, 153, 46, 154, 44, 155, //

			41, 49, 44, 48, 45, 50, //
			41, 49, 45, 50, 42, 51, //
			38, 53, 41, 52, 42, 54, //
			38, 53, 42, 54, 39, 55, //
			8, 57, 38, 56, 39, 58, //
			8, 57, 39, 58, 9, 59, //
			11, 85, 8, 84, 9, 86, //
			11, 85, 9, 86, 12, 87, //
			15, 89, 11, 88, 12, 90, //
			15, 89, 12, 90, 16, 91, //
			18, 93, 15, 92, 16, 94, //
			18, 93, 16, 94, 19, 95, //
			21, 121, 18, 120, 19, 122, //
			21, 121, 19, 122, 22, 123, //
			25, 125, 21, 124, 22, 126, ///
			25, 125, 22, 126, 26, 127, //
			28, 129, 25, 128, 26, 130, //
			28, 129, 26, 130, 29, 131, //
			49, 157, 28, 156, 29, 158, //
			49, 157, 29, 158, 50, 159, //
			46, 161, 49, 160, 50, 162, //
			46, 161, 50, 162, 47, 163, //
			44, 165, 46, 164, 47, 166, //
			44, 165, 47, 166, 45, 167, //

			42, 61, 45, 60, 6, 62, //
			42, 61, 6, 62, 43, 63, //
			39, 65, 42, 64, 43, 66, //
			39, 65, 43, 66, 40, 67, //
			9, 69, 39, 68, 40, 70, //
			9, 69, 40, 70, 2, 71, //
			12, 97, 9, 96, 2, 98, //
			12, 97, 2, 98, 13, 99, //
			16, 101, 12, 100, 13, 102, //
			16, 101, 13, 102, 17, 103, //
			19, 105, 16, 104, 17, 106, //
			19, 105, 17, 106, 3, 107, //
			22, 133, 19, 132, 3, 134, //
			22, 133, 3, 134, 23, 135, //
			26, 137, 22, 136, 23, 138, //
			26, 137, 23, 138, 27, 139, //
			29, 141, 26, 140, 27, 142, //
			29, 131, 27, 142, 7, 143, //
			50, 169, 29, 168, 7, 170, //
			50, 169, 7, 170, 51, 171, //
			47, 173, 50, 172, 51, 174, //
			47, 173, 51, 174, 48, 175, //
			45, 177, 47, 176, 48, 178, //
			45, 177, 48, 178, 6, 179, //

			13, 181, 2, 180, 40, 182, //
			13, 181, 40, 182, 52, 183, //
			17, 185, 13, 184, 52, 186, //
			17, 185, 52, 186, 54, 187, //
			3, 189, 17, 188, 54, 190, //
			3, 189, 54, 190, 23, 191, //
			52, 193, 40, 192, 43, 194, //
			52, 193, 43, 194, 53, 195, //
			54, 197, 52, 196, 53, 198, //
			54, 197, 53, 198, 55, 199, //
			23, 201, 54, 200, 55, 202, //
			23, 201, 55, 202, 27, 203, //
			53, 205, 43, 204, 6, 206, //
			53, 205, 6, 206, 48, 207, //
			55, 209, 53, 208, 48, 210, //
			55, 209, 48, 210, 51, 211, //
			27, 213, 55, 212, 51, 214, //
			27, 213, 51, 214, 7, 215 //
	};

	static float[] textCoords = new float[] {
			// array stores all the texture coordinates
			0, 0, // T0
			0.083f, 0, // T1
			0, 0.083f, // T2
			0.083f, 0.083f, // T3

			0.25f, 0.083f, // T4
			0.333f, 0.083f, // T5
			0.25f, 0.166f, // T6
			0.333f, 0.166f, // T7

			0.333f, 0.083f, // T8
			0.416f, 0.083f, // T9
			0.333f, 0.166f, // T10
			0.416f, 0.166f, // T11

			0.416f, 0.083f, // T12
			0.5f, 0.083f, // T13
			0.416f, 0.166f, // T14
			0.5f, 0.166f, // T15

			0.25f, 0.166f, // T16
			0.333f, 0.166f, // T17
			0.25f, 0.249f, // T18
			0.333f, 0.249f, // T19

			0.333f, 0.166f, //
			0.416f, 0.166f, //
			0.333f, 0.249f, //
			0.416f, 0.249f, //

			0.416f, 0.166f, //
			0.5f, 0.166f, //
			0.416f, 0.249f, //
			0.5f, 0.249f, //

			0.333f, 0, // T4
			0.416f, 0, // T5
			0.333f, 0.083f, // T6
			0.416f, 0.083f, // T7

			0.416f, 0, // T8
			0.5f, 0, // T9
			0.416f, 0.083f, // T10
			0.5f, 0.083f, // T11

			0, 0, //
			0.083f, 0, //
			0, 0.083f, //
			0.083f, 0.083f, //

			0.083f, 0.333f, //
			0.166f, 0.333f, //
			0.083f, 0.416f, //
			0.166f, 0.416f, //

			0, 0.416f, //
			0.083f, 0.416f, //
			0, 0.499f, //
			0.083f, 0.499f, //

			0.166f, 0.333f, //
			0.249f, 0.333f, //
			0.166f, 0.416f, //
			0.249f, 0.416f, //

			0.083f, 0.416f, //
			0.166f, 0.416f, //
			0.083f, 0.499f, //
			0.166f, 0.499f, //

			0, 0.333f, //
			0.083f, 0.333f, //
			0, 0.416f, //
			0.083f, 0.416f, //

			0.166f, 0.416f, //
			0.249f, 0.416f, //
			0.166f, 0.499f, //
			0.249f, 0.499f, //

			0.083f, 0.25f, //
			0.166f, 0.25f, //
			0.083f, 0.333f, //
			0.166f, 0.333f, //

			0.166f, 0.25f, //
			0.249f, 0.25f, //
			0.166f, 0.333f, //
			0.249f, 0.333f, //

			0, 0, //
			0.083f, 0, //
			0, 0.083f, //
			0.083f, 0.083f, //

			0.416f, 0.25f, //
			0.499f, 0.25f, //
			0.416f, 0.333f, //
			0.499f, 0.333f, //

			0.416f, 0.416f, //
			0.499f, 0.416f, //
			0.416f, 0.499f, //
			0.499f, 0.499f, //

			0.333f, 0.25f, //
			0.416f, 0.25f, //
			0.333f, 0.333f, //
			0.416f, 0.333f, //

			0.25f, 0.333f, //
			0.333f, 0.333f, //
			0.25f, 0.416f, //
			0.333f, 0.416f, //

			0.333f, 0.416f, //
			0.416f, 0.416f, //
			0.333f, 0.499f, //
			0.416f, 0.499f, //

			0.416f, 0.333f, //
			0.499f, 0.333f, //
			0.416f, 0.416f, //
			0.499f, 0.416f, //

			0.333f, 0.333f, //
			0.416f, 0.333f, //
			0.333f, 0.416f, //
			0.416f, 0.416f, //

			0.25f, 0.416f, //
			0.333f, 0.416f, //
			0.25f, 0.499f, //
			0.333f, 0.499f, //

			0, 0, //
			0.083f, 0, //
			0, 0.083f, //
			0.083f, 0.083f, //

			0.666f, 0.25f, //
			0.749f, 0.25f, //
			0.666f, 0.333f, //
			0.749f, 0.333f, //

			0.583f, 0.333f, //
			0.666f, 0.333f, //
			0.583f, 0.416f, //
			0.666f, 0.416f, //

			0.583f, 0.25f, //
			0.666f, 0.25f, //
			0.583f, 0.333f, //
			0.666f, 0.333f, //

			0.5f, 0.333f, //
			0.583f, 0.333f, //
			0.5f, 0.416f, //
			0.583f, 0.416f, //

			0.666f, 0.416f, //
			0.749f, 0.416f, //
			0.666f, 0.499f, //
			0.749f, 0.499f, //

			0.5f, 0.416f, //
			0.583f, 0.416f, //
			0.5f, 0.499f, //
			0.583f, 0.499f, //

			0.583f, 0.416f, //
			0.666f, 0.416f, //
			0.583f, 0.499f, //
			0.666f, 0.499f, //

			0.666f, 0.333f, //
			0.749f, 0.333f, //
			0.666f, 0.416f, //
			0.749f, 0.416f, //

			0, 0, //
			0.083f, 0, //
			0, 0.083f, //
			0.083f, 0.083f, //

			0.75f, 0.333f, //
			0.833f, 0.333f, //
			0.75f, 0.416f, //
			0.833f, 0.416f, //

			0.833f, 0.25f, //
			0.916f, 0.25f, //
			0.833f, 0.333f, //
			0.916f, 0.333f, //

			0.916f, 0.25f, //
			1, 0.25f, //
			0.916f, 0.333f, //
			1, 0.333f, //

			0.916f, 0.333f, //
			1, 0.333f, //
			0.916f, 0.416f, //
			1, 0.416f, //

			0.833f, 0.416f, //
			0.916f, 0.416f, //
			0.833f, 0.5f, //
			0.916f, 0.5f, //

			0.75f, 0.416f, //
			0.833f, 0.416f, //
			0.75f, 0.5f, //
			0.833f, 0.5f, //

			0.833f, 0.333f, //
			0.916f, 0.333f, //
			0.833f, 0.416f, //
			0.916f, 0.416f, //

			0.916f, 0.416f, //
			1, 0.416f, //
			0.916f, 0.5f, //
			1, 0.5f, //

			0, 0, //
			0.083f, 0, //
			0, 0.083f, //
			0.083f, 0.083f, //

			0.416f, 0.5f, //
			0.5f, 0.5f, //
			0.416f, 0.583f, //
			0.5f, 0.583f, //

			0.333f, 0.583f, //
			0.416f, 0.583f, //
			0.333f, 0.666f, //
			0.416f, 0.666f, //

			0.416f, 0.583f, //
			0.5f, 0.583f, //
			0.416f, 0.666f, //
			0.5f, 0.666f, //

			0.25f, 0.583f, //
			0.333f, 0.583f, //
			0.25f, 0.666f, //
			0.333f, 0.666f, //

			0.333f, 0.5f, //
			0.416f, 0.5f, //
			0.333f, 0.583f, //
			0.416f, 0.583f, //

			0.333f, 0.666f, //
			0.416f, 0.666f, //
			0.333f, 0.75f, //
			0.416f, 0.75f, //

			0.25f, 0.666f, //
			0.333f, 0.666f, //
			0.25f, 0.75f, //
			0.333f, 0.75f, //

			0.416f, 0.666f, //
			0.5f, 0.666f, //
			0.416f, 0.75f, //
			0.5f, 0.75f,// T215

	};

	public static void main(String args[]) {
		Application.launch(args);
	}

	@Override
	public void init() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// initiation of the primary stage
		primaryStage.setTitle("Cubic Game");
		// set up the title
		primaryStage.setFullScreen(true);
		PhongMaterial mat = new PhongMaterial();
		// set up material
		mat.setDiffuseMap(new Image("File:Images/texture.jpg", false));
		// select image and set up texture mapping
		TriangleMesh mesh = new TriangleMesh();
		// set up the triangle mesh
		mesh.getPoints().addAll(points);
		mesh.getFaces().addAll(faces);
		mesh.getTexCoords().addAll(textCoords);
		// add points, faces, and texture coordinates array to mesh
		MeshView cube = new MeshView(mesh);
		cube.setDrawMode(DrawMode.FILL);
		cube.setMaterial(mat);
		cube.setTranslateX(550);
		cube.setTranslateY(400);
		cube.setTranslateZ(200);
		root.getChildren().add(cube);
		// add children to root

		scene.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
			// set up key pressed event
			@Override
			public void handle(javafx.scene.input.KeyEvent event) {
				if (event.getCode() == KeyCode.RIGHT) {
					// move right
					for (int i = 0; i < 4; i++) {
						swap(textCoords, blank[i], blank[i] + 4);
						blank[i] += 4;
					}
				} else if (event.getCode() == KeyCode.LEFT) {
					// move left
					for (int i = 0; i < 4; i++) {
						swap(textCoords, blank[i], blank[i] - 4);
						blank[i] -= 4;
					}
				} else if (event.getCode() == KeyCode.UP) {
					// move up
					for (int i = 0; i < 4; i++) {
						swap(textCoords, blank[i], blank[i] - 12);
						blank[i] -= 12;
					}
				} else if (event.getCode() == KeyCode.DOWN) {
					// move down
					for (int i = 0; i < 4; i++) {
						swap(textCoords, blank[i], blank[i] + 12);
						blank[i] += 12;
					}
				}
				mesh.getTexCoords().setAll(textCoords);
				// update texture coordinates
			}
		});

		scene.setOnRotate(new EventHandler<javafx.scene.input.RotateEvent>() {
			// set up rotation event
			@Override
			public void handle(RotateEvent event) {
				// rotate at z axis
				if (event.getAngle() > 0)
					Transformation.rotation('z', 1, points);
				else if (event.getAngle() < 0)
					Transformation.rotation('z', -1, points);
				mesh.getPoints().setAll(points);
			}
		});

		scene.setOnScroll(new EventHandler<javafx.scene.input.ScrollEvent>() {
			// set up scroll event
			@Override
			public void handle(ScrollEvent event) {
				// switch between the blank square with other squares
				int blankfacefront = 72, blankfacekleft = 36, blankfaceright = 108, blankfaceback = 144,
						blankfacetop = 0, blankfacebottom = 180;

				if (Transformation.Z < 103 && Transformation.Z > 97) {
					for (int i = 0; i < 4; i++)
						blank[i] = blankfacefront + i;
				} else if (Transformation.Z < -197 && Transformation.Z > -203) {
					for (int i = 0; i < 4; i++)
						blank[i] = blankfacekleft + i;
				} else if (Transformation.Z < 203 && Transformation.Z > 197) {
					for (int i = 0; i < 4; i++)
						blank[i] = blankfaceright + i;
				} else if (Transformation.Z < -97 && Transformation.Z > -103) {
					for (int i = 0; i < 4; i++)
						blank[i] = blankfaceback + i;
				} else if (Transformation.Z < -297 && Transformation.Z > -303) {
					for (int i = 0; i < 4; i++)
						blank[i] = blankfacetop + i;
				} else if (Transformation.Z < 303 && Transformation.Z > 297) {
					for (int i = 0; i < 4; i++)
						blank[i] = blankfacebottom + i;
				}
				// rotate at y axis
				if (event.getDeltaY() < 0) {
					Transformation.rotation('x', 1, points);
				} else if (event.getDeltaY() > 0)
					Transformation.rotation('x', -1, points);
				// rotate at x axis
				if (event.getDeltaX() > 0) {
					Transformation.rotation('y', 1, points);
				} else if (event.getDeltaX() < 0) {
					Transformation.rotation('y', -1, points);
				}
				mesh.getPoints().setAll(points);
				// update points
			}
		});
		primaryStage.setScene(scene);
		primaryStage.show();
		// show the stage
	}

	public static void swap(float[] text, int a, int b) {
		// swap the squares
		float temp = text[2 * a];
		float temp2 = text[2 * a + 1];

		text[2 * a] = text[2 * b];
		text[2 * b] = temp;
		text[2 * a + 1] = text[2 * b + 1];
		text[2 * b + 1] = temp;

	}

	public static void shuffle(float[] text) {
		// shuffle the squares
		float hold1, hold2, hold3, hold4 = 0;
		for (int i = 4; i < 28; i += 4) {
			for (int j = i; j < i + 4; j++) {
				hold1 = text[j];
				text[j] = text[j + 4];
				text[j + 4] = hold1;
			}
		}
	}
}
