package com.marcelslum.ultnogame;
import android.util.Log;
import java.util.ArrayList;

public class MyTextView extends Entity{
  
	public ArrayList<Text> texts;
	public float width;
	public float height;
	public float size;
	public Font font;
	public float padding = 0.2f;
	public float currentTranslateY;
	
	boolean desacelerationActivated = false;
    float lastMovement;
	private boolean cancelNextPress;

	private final String TAG = "MyTextView";

	float translateY = 0;
	int alignment;
  
	public MyTextView(String name, float x, float y, float width, float height, float size, Font font, Color color, int alignment, float padding){
		
		super(name, x, y, Entity.TYPE_TEXT_VIEW);
		this.width = width;
		this.height = height;
		this.size = size;
		this.font = font;
		this.color = color;
		this.alignment = alignment;
		this.padding = padding;
		texts = new ArrayList<>();

		final MyTextView innerMyTextView = this;
		setListener(new InteractionListener(this.name, x, y, width, height, 5000, this));

		listener.setPressListener(new InteractionListener.PressListener() {
			@Override
			public void onPress() {Log.e(TAG, "press");}
			@Override
			public void onUnpress() {Log.e(TAG, "unpress");}
		});
		
		listener.setMoveListener(new InteractionListener.MoveListener() {
			@Override
			public void onMoveDown() {

				Log.e(TAG, "moveDown");

			    if (innerMyTextView.desacelerationActivated){
				innerMyTextView.desacelerationActivated = false;
				innerMyTextView.cancelNextPress = true;
			    }
			}

			@Override
			public void onMove(TouchEvent touch, long startTime) {

				Log.e(TAG, "move");
			    if (!isBlocked){
				innerMyTextView.move(touch.y - touch.previousY, true);
				innerMyTextView.lastMovement = touch.y - touch.previousY;
			    }
			}

			@Override
			public void onMoveUp(TouchEvent touch, long startTime) {
				Log.e(TAG, "moveUp");
			    innerMyTextView.desacelerationActivated = true;
			}
		});
	}

	public void checkTransformations(boolean updatePrevious){
		super.checkTransformations(updatePrevious);
		desacelerate();
	}

	public void clearTexts(){
		texts.clear();
		childs.clear();
	}

	public void addText(String text, Color newTextColor, float sizeProportion){


		ArrayList<Text> newTexts = Text.splitStringAtMaxWidth("novo text", text, font, newTextColor, size * sizeProportion, width, alignment);

		texts.addAll(newTexts);
		Text.doLinesWithStringCollection(texts, y, size * sizeProportion, size * sizeProportion * padding, false);

		for (int i = 0; i < texts.size(); i++){
			texts.get(i).setX(x);
		}

		if (childs != null){
			childs.clear();
		}

		for (int i = 0; i < texts.size(); i++){
			addChild(texts.get(i));
		}
	}

	public void addText(String text, Color newTextColor){
		addText(text, newTextColor, 1f);
	}
	
	public void render(float[] matrixView, float[] matrixProjection){
		for (int i = 0; i < texts.size(); i++){
			texts.get(i).render(matrixView, matrixProjection);
		}
	}
	
	private void desacelerate() {
		if (lastMovement < 0) {
		    if (lastMovement + 0.8f < 0) {
			move(lastMovement + 0.8f, true);
			lastMovement += 0.8f;
		    } else {
			desacelerationActivated = false;
		    }
		} else if (lastMovement > 0) {
		    if (lastMovement - 0.8f > 0) {
			move(lastMovement - 0.8f, true);
			lastMovement -= 0.8f;
		    } else {
			desacelerationActivated = false;
		    }
		}
	}
	

	public void move(float iconTranslateY, boolean updateCurrentTranslateY) {



		Text lastText = texts.get(texts.size()-1);

		Log.e(TAG, "lastText.positionY "+lastText.positionY);
		Log.e(TAG, "size "+size);
		Log.e(TAG, "iconTranslateY "+iconTranslateY);
		Log.e(TAG, "y "+y);
		Log.e(TAG, "height "+height);

		if (lastText.positionY + size + iconTranslateY < y + height){
			Log.e(TAG, "lastText.positionY + size + iconTranslateY > y + height");
		    iconTranslateY = (y + height) - (lastText.positionY + size);
		    if (desacelerationActivated){
			desacelerationActivated = false;
		    }
		}

		Text firstText = texts.get(0);


		Log.e(TAG, "firstText.positionY "+firstText.positionY);
		Log.e(TAG, "y "+y);

		if (firstText.positionY + iconTranslateY > y){
			Log.e(TAG, "firstText.positionY - iconTranslateY > y");
		    iconTranslateY = y - firstText.positionY;
		    if (desacelerationActivated){
			desacelerationActivated = false;
		    }
		}

		for (int i = 0; i < texts.size(); i++){
		    texts.get(i).translate(0f, iconTranslateY);
		    if (texts.get(i).shadowText != null){
			texts.get(i).shadowText.translate(0f, iconTranslateY);
		    }
		}

		if (updateCurrentTranslateY) {
		    currentTranslateY += iconTranslateY;
		}
	}
}

