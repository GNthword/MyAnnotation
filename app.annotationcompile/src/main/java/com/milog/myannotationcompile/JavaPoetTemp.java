package com.milog.myannotationcompile;

import com.milog.annotation.MiloConfig3;
import com.squareup.javapoet.AnnotationSpec;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/**
 * Created by miloway on 2018/6/29.
 */

public class JavaPoetTemp {


    public static void generateHelloWorld(Set<? extends TypeElement> annotations, Filer filer) {

        for (TypeElement element : annotations) {
            if (element.getQualifiedName().toString().equals(MiloConfig3.class.getCanonicalName())) {
                // main method
                MethodSpec main = MethodSpec.methodBuilder("main")
                        .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
                        .returns(void.class)
                        .addParameter(String[].class, "args")
                        .addStatement("$T.out.println($S)", System.class, "Hello, JavaPoet!")
                        .build();
                // HelloWorld class
                TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld")
                        .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
                        .addMethod(main)
                        .build();

                try {
                    // build com.example.HelloWorld.java
                    JavaFile javaFile = JavaFile.builder("com.example", helloWorld)
                            .addFileComment(" This codes are generated automatically. Do not modify!")
                            .build();
                    // write to file
                    javaFile.writeTo(filer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void genMyMyLinearLayout(Filer filer) {

        TypeSpec.Builder builder = TypeSpec.classBuilder("MyMyLinearLayout");

        builder.addModifiers(Modifier.PUBLIC)
                .superclass(ClassName.bestGuess("com.milog.myannotation.MyLinearLayout"));

        MethodSpec test = MethodSpec.methodBuilder("test")
                .addAnnotation(Override.class)
                .addModifiers(Modifier.PUBLIC)
                .returns(void.class)
                .addStatement("//here")
                .addStatement("System.out.println(\"MyMyLinearLayout here\");")
                .build();

        MethodSpec construct = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(ClassName.bestGuess("android.content.Context"), "context")
                .addParameter(ClassName.bestGuess("android.util.AttributeSet"), "attrs")
                .addStatement("super(context, attrs);")
                .build();

        builder.addMethod(construct);
        builder.addMethod(test);



//        ublic MyLinearLayout(Context context, AttributeSet attrs) {
//            super(context, attrs);
//        }
        try {
            // build com.example.HelloWorld.java
            JavaFile javaFile = JavaFile.builder("com.milog.myannotation", builder.build())
                    .addFileComment(" This codes are generated automatically. Do not modify!")
                    .build();
            // write to file
            javaFile.writeTo(filer);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static void modifyTheFile(Set<? extends TypeElement> annotations, Messager messager) {

        for (TypeElement element : annotations) {
            if (element.getQualifiedName().toString().equals(MiloConfig3.class.getCanonicalName())) {
                // main method
                File file = new File("a.txt");
                messager.printMessage(Diagnostic.Kind.NOTE, "here1");
                if (!file.exists()){
                    messager.printMessage(Diagnostic.Kind.NOTE, "here2");
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        messager.printMessage(Diagnostic.Kind.NOTE, e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
