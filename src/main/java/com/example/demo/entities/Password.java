package com.example.demo.entities;

import com.example.demo.enums.PowerEnums;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.ArrayList;
@Getter
@Setter
@Service
@NoArgsConstructor
public class Password {
    private int totalOfLetters = 0;
    private int totalOfNumbers= 0;
    private int totalOfUpperCaseLetters= 0;
    private int totalOfLowerCaseLetters= 0;
    private int totalOfEspecialCharacter= 0;
    String senhaString;
    private int points;
    private PowerEnums powerEnums;
    ArrayList<String> senha = new ArrayList<>();
    public Password(String s){
            for(int i = 0; i < s.length(); i++){
                senhaString = s;
                senha.add(s.substring(i,i+1));
            }
        IsAGoodPassword();
    }

    private void IsAGoodPassword(){
        for(int i = 0; i < senha.size() ; i++){
            if(senha.get(i).matches("[A-Z]")){
                    totalOfLetters++;
                    totalOfUpperCaseLetters++;
            }else if(senha.get(i).matches("[a-z]")){
                totalOfLetters++;
                totalOfLowerCaseLetters++;
            }else if(senha.get(i).matches("[0-9]")){
                    totalOfNumbers++;
            }else{
                totalOfEspecialCharacter++;

            }
        }

        points =  (totalOfLetters*4) + (totalOfNumbers*5) + (totalOfUpperCaseLetters*2) + (totalOfLowerCaseLetters*2)+ (totalOfEspecialCharacter*15);
        System.out.println("Total de letras:"+totalOfLetters );
        System.out.println("Total de numeros:"+totalOfNumbers );
        System.out.println("Total de letras maiusculas:"+totalOfUpperCaseLetters );
        System.out.println("Total de letras minusculas:"+totalOfLowerCaseLetters );
        System.out.println("Total de especiais:"+totalOfEspecialCharacter );
        System.out.println("Pontos:"+points);
        if(points < 30){
            powerEnums = PowerEnums.AVERAGE;
        }else if(points >= 30 && points<=70){
            powerEnums = PowerEnums.WEAK;
        }else{
            powerEnums = PowerEnums.STRONG;
        }
    }
    public void IsAGoodPassword(String senha){

    }

}
