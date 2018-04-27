#include<stdio.h>
 
int main()
{
    char message[53], variance;
    int i;
    int pi[] = {0,1,1,2,3,5,8,1,3,2,1,3,4,5,5,8,9,1,4,4,2,3,3,3,7,7,6,1,0,9,8,7,1,5,9,7,2,5,8,4,4,1,8,1,6,7,6,5,1,0,9,4,6};
    
    printf("Input decryption message :  ");
    gets(message);
    
    for(i = 0; message[i] != '\0'; ++i){
        variance = message[i];
        
        if(variance >= 'a' && variance <= 'z'){
            variance = variance - pi[i];
            
            if(variance < 'a'){
                variance = variance + 'z' - 'a' + 1;
            }
            
            message[i] = variance;
        }
        else if(variance >= 'A' && variance <= 'Z'){
            variance = variance - pi[i];
            
            if(variance < 'A'){
                variance = variance + 'Z' - 'A' + 1;
            }
            
            message[i] = variance;
        }
    }
    
    printf("Decrypted message : %s\n", message);
    
    return 0;
}