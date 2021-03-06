package com.marcelslum.ultnogame;


import android.opengl.GLES20;
import android.util.Log;

import java.util.ArrayList;

public class Text extends Entity implements Poolable<Text>{

    public final static int TEXT_ALIGN_LEFT = 0;
    public final static int TEXT_ALIGN_CENTER = 1;
    public final static int TEXT_ALIGN_RIGHT = 2;


    public String text;
    public float size;

    public float width;
    public Font font;

    private int indexVertices;
    private int indexIndices;
    private int indexUvs;
    private int indexColors;
    public float[] charData;
    public int align;
    public Text shadowText;
    private Color shadowColor;
    private int poolID;

    boolean noDraw = false;


    @Override
    public void setPoolID(int id) {
        poolID = id;
    }

    @Override
    public int getPoolID() {
        return poolID;
    }

    @Override
    public Text get() {
        return this;
    }

    @Override
    public void clean() {
        super.clean();
        align = TEXT_ALIGN_LEFT;
    }

    public Text(){
        super("name", 0, 0, Entity.TYPE_TEXT);
    }

    public void setData(String name, float x, float y, float size, String text, Font font, Color color, int align) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.text = text;
        this.size = size;
        this.color = color;
        this.font = font;
        this.align = align;
        program = font.program;
        textureId = font.textureId;
        charData = new float[7];
        textureData = TextureData.getTextureDataById(TextureData.TEXTURE_JEFT_SET_ID);
        super.setData();
        setDrawInfo();
    }


    public Text(String name, float x, float y, float size, String text, Font font, Color color, int align) {
        
        super(name, x, y, Entity.TYPE_TEXT);
        this.text = text;
        this.size = size;
        this.color = color;
        this.font = font;
        this.align = align;
        program = font.program;
        textureId = font.textureId;
        charData = new float[7];
        textureData = TextureData.getTextureDataById(TextureData.TEXTURE_JEFT_SET_ID);
        setDrawInfo();
        
    }

    public Text(String name, float x, float y, float size, String text, Font font, Color color, boolean noDraw) {
        super(name, x, y, Entity.TYPE_TEXT);
        this.text = text;
        this.size = size;
        this.color = color;
        this.font = font;
        program = font.program;
        textureId = font.textureId;
        align = TEXT_ALIGN_LEFT;
        if (noDraw) {
            textureData = TextureData.getTextureDataById(TextureData.TEXTURE_JEFT_SET_ID);
        }
        charData = new float[7];
        if (noDraw) {
            setDrawInfo();
        }
    }

    public Text(String name, float x, float y, float size, String text, Font font, Color color) {
        super(name, x, y, Entity.TYPE_TEXT);
        this.text = text;
        this.size = size;
        this.color = color;
        this.font = font;
        program = font.program;
        textureId = font.textureId;
        align = TEXT_ALIGN_LEFT;
        textureData = TextureData.getTextureDataById(TextureData.TEXTURE_JEFT_SET_ID);
        charData = new float[7];
        setDrawInfo();
    }

    public Text(String name, float x, float y, float size, String text, Font font) {
        super(name, x, y, Entity.TYPE_TEXT);
        this.text = text;
        this.size = size;

        this.color = new Color(0f,0f,0f,1f);
        this.font = font;
        program = font.program;
        textureId = font.textureId;
        align = TEXT_ALIGN_LEFT;
        textureData = TextureData.getTextureDataById(TextureData.TEXTURE_JEFT_SET_ID);
        charData = new float[7];
        setDrawInfo();
    }

    public void setText(String text){

        if (text.length() <= 0){
            text = ".";
        }

        this.text = text;
        if (shadowText != null) {
            shadowText.setText(text);
        }
        setDrawInfo();
    }

    public void translate(float translateX, float translateY) {
        this.translateX = translateX;
        this.translateY = translateY;
    }

    public void addShadow(Color shadowColor){
        this.shadowColor = shadowColor;

        shadowText = new Text(name+"shadow", x + (size*0.09f), y + (size*0.09f), size, text, font, shadowColor, align);
        addChild(shadowText);
    }

    @Override
    public void prepareRender(float[] matrixView, float[] matrixProjection) {
        if (shadowText != null){
            shadowText.prepareRender(matrixView, matrixProjection);
        }
        super.prepareRender(matrixView, matrixProjection);
    }

    public void setDrawInfo(){

        boolean useVbo = true;

        if (useVbo) {
            if (vbo == null || vbo.length == 0) {
                vbo = new int[3];
                GLES20.glGenBuffers(3, vbo, 0);
                //Log.e(TAG, " text "+ text + "vbo create " + " vbo " + vbo[0] + " " + vbo[1]+ " " + vbo[2]);
            }

            if (ibo == null || ibo.length == 0) {
                ibo = new int[1];
                GLES20.glGenBuffers(1, ibo, 0);
                //Log.e(TAG, " text " + text + " ibo create " + ibo[0]);
            }
        }


        float xOffset = 0f;
        if (align == TEXT_ALIGN_RIGHT) {
            xOffset = -calculateWidth();
        } else if (align == TEXT_ALIGN_CENTER){
            xOffset = -(calculateWidth()/2);
        }

        indexVertices = 0;
        indexIndices = 0;
        indexUvs = 0;
        indexColors = 0;

        // Get the total amount of characters
        int charcount = this.text.length();

        verticesData = null;
        colorsData = null;
        uvsData = null;
        indicesData = null;
        
        initializeData(charcount * 12, charcount * 6, charcount * 8, charcount * 16);

        convertTextToTriangleInfo(xOffset);
        
        verticesBuffer = Utils.generateOrUpdateFloatBuffer(verticesData,verticesBuffer);
        uvsBuffer = Utils.generateOrUpdateFloatBuffer(uvsData,uvsBuffer);
        indicesBuffer = Utils.generateOrUpdateShortBuffer(indicesData,indicesBuffer);
        colorsBuffer = Utils.generateOrUpdateFloatBuffer(colorsData,colorsBuffer);

        width = calculateWidth();

        if (useVbo) {
            //Log.e(TAG, name + " -> binding buffer " + vbo[0]);
            GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo[0]);
            GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, verticesBuffer.capacity() * SIZEOF_FLOAT,
                    verticesBuffer, GLES20.GL_STATIC_DRAW);

            GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo[1]);
            GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, uvsBuffer.capacity() * SIZEOF_FLOAT,
                    uvsBuffer, GLES20.GL_STATIC_DRAW);

            GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo[2]);
            GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, colorsBuffer.capacity() * SIZEOF_FLOAT,
                    colorsBuffer, GLES20.GL_STATIC_DRAW);

            GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, ibo[0]);
            GLES20.glBufferData(GLES20.GL_ELEMENT_ARRAY_BUFFER, indicesBuffer.capacity() * SIZEOF_SHORT,
                    indicesBuffer, GLES20.GL_STATIC_DRAW);

            GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
            GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);
        }


    }

    private void convertTextToTriangleInfo(float xOffset){
        // Get attributes from text object
        float cursor = 0 + xOffset;

        float proportion = size/font.lineHeight;

        for(int j=0; j<text.length(); j++){
            char c = text.charAt(j);
            int c_val = (int)c;

            if (charData == null){
                charData = new float[7];
            }

            //Log.e(TAG, "char " + String.valueOf(c));
            //Log.e(TAG, "chc_val " + c_val);

            float indx = font.getCharToIndex(c_val, charData);

            if(indx==-1.0f) {
                cursor += (size);
                continue;
            }

            /*
            float x = charData[0]/font.textureSize;
            float x2 = (charData[0] + charData[2])/font.textureSize;
            float y = charData[1]/font.textureSize;
            float y2 = (charData[1] + charData[3])/font.textureSize;
            */

            float x = textureData.x + (charData[0]/TextureData.textureSize);
            float x2 = textureData.x + ((charData[0] + charData[2])/TextureData.textureSize);
            float y = textureData.y + ((charData[1]-0.5f)/TextureData.textureSize);
            float y2 = textureData.y + ((charData[1] + charData[3]+0.5f)/TextureData.textureSize);

            // Creating the triangle information
            float[] vec = new float[12];
            float[] uv = new float[8];
            float[] colors;

            float destLeft   = cursor + (charData[4]*proportion);
            float destTop    = 0 + (charData[5]*proportion); ///// - (size*0.1f);
            float destRight  = destLeft + (charData[2]*proportion);
            if (c_val == 105){ // afina um pouco a letra i
                destRight  = destLeft + ((charData[2]*proportion)* 0.7f);
            } else if (c_val == 108){ // afina um pouco a letra l
                destRight  = destLeft + ((charData[2]*proportion)* 0.85f);
            }

            float destBottom = destTop + (charData[3]*proportion);/////////- (size*0.1f);

            vec[0] = cursor;
            vec[1] = destBottom;
            vec[2] = 0f;
            vec[3] = cursor;
            vec[4] = destTop;
            vec[5] = 0f;
            vec[6] = destRight;
            vec[7] = destTop;
            vec[8] = 0f;
            vec[9] = destRight;
            vec[10] = destBottom;
            vec[11] = 0f;

/*
            vec[0] = cursor;
            vec[1] = 0 + size;
            vec[2] = 0f;
            vec[3] = cursor;
            vec[4] = 0;
            vec[5] = 0f;
            vec[6] = cursor + (size*(charData[2]/charData[3]));
            vec[7] = 0;
            vec[8] = 0f;
            vec[9] = cursor + (size*(charData[2]/charData[3]));
            vec[10] = 0 + size;
            vec[11] = 0f;
*/
            colors = new float[]
                    {   this.color.r, this.color.g, this.color.b, this.color.a,
                        this.color.r, this.color.g, this.color.b, this.color.a,
                        this.color.r, this.color.g, this.color.b, this.color.a,
                        this.color.r, this.color.g, this.color.b, this.color.a
                    };

            //uv[0] = x;
            //uv[1] = y2 + 0.001f;
            //uv[2] = x;
            //uv[3] = y - 0.001f;
            //uv[4] = x2;
            //uv[5] = y - 0.001f;
            //uv[6] = x2;
            //uv[7] = y2 + 0.001f;
            
            
            uv[0] = x;
            uv[1] = y2;
            uv[2] = x;
            uv[3] = y;
            uv[4] = x2;
            uv[5] = y;
            uv[6] = x2;
            uv[7] = y2;
            
            

            short[] inds = {0, 1, 2, 0, 2, 3};

            // Add our triangle information to our collection for 1 render call.
            addCharRenderInformation(vec, colors, uv, inds);

            // Calculate the new position
            cursor +=  charData[6] * proportion;
            if (c_val == 32){
                cursor += size*0.15f;
            }
        }
    }

    public float calculateWidth(){
        float cursor = 0;

        for(int j=0; j<text.length(); j++)
        {
            char c = text.charAt(j);
            int c_val = (int)c;

            if (charData == null){
                charData = new float[7];
            }

            float indx = font.getCharToIndex(c_val, charData);

            if(indx==-1.0f) {
                // unknown character, we will add a space for it to be save.
                cursor += (size);
                continue;
            }

            cursor += (size/font.lineHeight) * charData[6];
        }
        return cursor;
    }
    
    public void updateVerticesData(float xOffset){
        
        convertTextToTriangleInfo(xOffset);
        
        verticesBuffer = Utils.generateOrUpdateFloatBuffer(verticesData,verticesBuffer);
        width = calculateWidth();
        
        verticesBuffer = Utils.generateOrUpdateFloatBuffer(verticesData, verticesBuffer);
               
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo[0]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, verticesBuffer.capacity() * SIZEOF_FLOAT,
                        verticesBuffer, GLES20.GL_STATIC_DRAW);

        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);
  
    }

    public void addCharRenderInformation(float[] vec, float[] cs, float[] uv, short[] indi)
    {
        // We need a base value because the object has indices related to
        // that object and not to this collection so basicly we need to
        // translate the indices to align with the vertexlocation in ou
        // vecs array of vectors.
        short base = (short) (indexVertices / 3);

        // We should add the vec, translating the indices to our saved vector
        for(int i=0;i<vec.length;i++)
        {
            verticesData[indexVertices] = vec[i];
            indexVertices++;
        }

        // We should add the colors, so we can use the same texture for multiple effects.
        for(int i=0;i<cs.length;i++)
        {
            colorsData[indexColors] = cs[i];
            indexColors++;
        }

        // We should add the uvs
        for(int i=0;i<uv.length;i++)
        {
            uvsData[indexUvs] = uv[i];
            indexUvs++;
        }

        // We handle the indices
        for(int j=0;j<indi.length;j++)
        {
            indicesData[indexIndices] = (short) (base + indi[j]);
            indexIndices++;
        }
    }

    public void setX(float x) {
        this.x = x;
        setDrawInfo();

        if (shadowText != null){
            shadowText.setX(x + (size*0.05f));
        }

    }

    public void setColor(Color color) {
        this.color = color;
        /*
        for(int j=0; j<text.length(); j++){  
            colorsData[0 + (j * 16)] = color.r;
            colorsData[1 + (j * 16)] = color.g;
            colorsData[2 + (j * 16)] = color.b;
            colorsData[3 + (j * 16)] = color.a;
            colorsData[4 + (j * 16)] = color.r;
            colorsData[5 + (j * 16)] = color.g;
            colorsData[6 + (j * 16)] = color.b;
            colorsData[7 + (j * 16)] = color.a;
            colorsData[8 + (j * 16)] = color.r;
            colorsData[9 + (j * 16)] = color.g;
            colorsData[10 + (j * 16)] = color.b;
            colorsData[11 + (j * 16)] = color.a;
            colorsData[12 + (j * 16)] = color.r;
            colorsData[13 + (j * 16)] = color.g;
            colorsData[14 + (j * 16)] = color.b;
            colorsData[15 + (j * 16)] = color.a;  
        }

        colorsBuffer = Utils.generateOrUpdateFloatBuffer(colorsData, colorsBuffer);


        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, vbo[2]);
        GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, colorsBuffer.capacity() * SIZEOF_FLOAT,
                        colorsBuffer, GLES20.GL_STATIC_DRAW);
        
        GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, 0);
        GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, 0);
        
        */
        this.setDrawInfo();
    }

    @Override
    public float getWidth() {
        return width;
    }

    public float getTransformedWidth(){
        return width * accumulatedScaleX;
    }

    @Override
    public float getHeight() {
        return size*1.5f;
    }

    public void reduceWidth(float desiredWidth) {
        int length = text.length();
        Text textForMeasure;
        float widthOfText;
        int contador = 1;
        for (int i = 0; i < length; i++) {
            //Log.e("text", "testando "+text.substring(0, length - contador));
            textForMeasure = new Text("text", 0f, 0f, size, text.substring(0, length - contador), Game.font, color);
            widthOfText = textForMeasure.calculateWidth();
            //Log.e("text", "width "+widthOfText);
            if (widthOfText < desiredWidth) {
                //Log.e("text", "texto final ");
                setText(text.substring(0, length - contador).concat("..."));
                break;
            }
            contador += 1;
        }
    }

    public static void doLinesWithStringCollection(ArrayList<Text> texts, float y, float size, float padd, boolean topPadd){

        float textY = y;

        if (topPadd){
            textY += padd;
        }

        for (int i = 0; i < texts.size(); i++){
            texts.get(i).setY(textY);
            textY += (size + padd);
        }

    }



    public static ArrayList<Text> splitStringAtMaxWidth(String name, String text, Font font, Color color, float size, float maxWidth, int align){

        ArrayList<Text> returnText = new ArrayList<>();

        Text textForMeasure = new Text(name, 0f, 0f, size, text, font, color, align);
        float widthOfText = textForMeasure.calculateWidth();

        if (widthOfText > maxWidth) {

            String [] splitedString = text.split(" ");
            String stringToTest = splitedString[0];

            int elementToAdd = 1;
            Text lastText = new Text("text", 0f, 0f, size, ".", font, color, true);

            int limite = 100;
            int contador = 0;

            do {
                do {
                    contador += 1;
                    textForMeasure = new Text("text"+contador, 0f, 0f, size, stringToTest, font, color, true);
                    widthOfText = textForMeasure.calculateWidth();
                    if (widthOfText > (maxWidth*0.9f)) {
                        elementToAdd -= 1;
                        stringToTest = splitedString[elementToAdd];
                        elementToAdd += 1;
                        break;
                    }
                    lastText = textForMeasure;
                    if (elementToAdd > (splitedString.length-1)){
                        elementToAdd += 1;
                        break;
                    }
                    stringToTest = stringToTest + " " + splitedString[elementToAdd];
                    elementToAdd += 1;
                } while (widthOfText < (maxWidth*0.9f) && (splitedString.length+1) > elementToAdd && contador < limite);
                //Log.e("textBox", "adicionando texto: "+lastText.text);
                returnText.add(new Text(lastText.name, lastText.x, lastText.y, lastText.size, lastText.text,
                        lastText.font, lastText.color, align));
                //Log.e("textBox", "elementToAdd "+elementToAdd);

            } while ((splitedString.length+1) > elementToAdd && contador < limite);

        } else {
            returnText.add(textForMeasure);
        }

        for (int i = 0; i < returnText.size(); i++){
            returnText.get(i).name = name + "line" + i;
        }

        return returnText;
    }

    @Override
    public void display(){
        isVisible = true;
        if (shadowText != null) {
            shadowText.display();
        }
    }

    @Override
    public void clearDisplay(){
        isVisible = false;
        if (shadowText != null) {
            shadowText.clearDisplay();
        }
    }

    public void setAlpha(float v) {
        alpha = v;
        if (shadowText != null){
            shadowText.alpha = v;
        }
    }

    public void setY(float v) {
        y = v;
        if (shadowText != null){
            shadowText.y = v + (size*0.05f);
        }
    }
}
