precision mediump float;
varying float alpha;
varying vec2 vv2_texCoord;
uniform sampler2D us_texture;
void main() {
   vec4 color = texture2D( us_texture, vv2_texCoord);
   if (color.a < 0.001) discard;
   gl_FragColor = vec4(color.r, color.g, color.b, color.a * alpha * 0.5);
   //gl_FragColor = vec4(0.8, 0.2, 0.9, 1.0);
   //gl_FragColor = vec4(color.r, color.g, color.b, 1.0);
}
