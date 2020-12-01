public class Main {

    public static void main(String[] args) {
        myType n = formString("?1???2???3???1?",0);
        System.out.println(n.outputString);
    }

    static class myType {
        boolean isValid;
        String outputString;

        myType(boolean isV, String s){
            isValid = isV;
            outputString = s;
        }
    }
    public static myType formString(String curString, int index){
        if(index>=curString.length()) return new myType(true,curString);
        int currentIndex = -1;
        String modifiedString = "";
        for(int iteratorIndex =index; iteratorIndex<curString.length();iteratorIndex++){
            if(curString.charAt(iteratorIndex)=='?'){
                currentIndex = iteratorIndex;
                break;
            }
        }
        if(currentIndex==-1) return new myType(true,curString);
        char[] array = curString.toCharArray();
        if(((currentIndex-1==-1) ||  (array[currentIndex-1]!='1')) && ((currentIndex+1==array.length ) ||(array[currentIndex+1]!='1')) ) {

            array[currentIndex] = '1';
            modifiedString = String.valueOf(array);


            myType obj1 = formString(modifiedString, currentIndex+1);
            if (obj1.isValid) return obj1;
        }

        if(((currentIndex-1==-1) ||  (array[currentIndex-1]!='2')) && ((currentIndex+1==array.length ) ||(array[currentIndex+1]!='2')) ) {
            array[currentIndex] = '2';
            modifiedString = String.valueOf(array);

            myType obj2 = formString(modifiedString, currentIndex+1);
            if (obj2.isValid) return obj2;
        }

        if(((currentIndex-1==-1) ||  (array[currentIndex-1]!='3')) && ((currentIndex+1==array.length ) ||(array[currentIndex+1]!='3')) ) {
            array[currentIndex] = '3';
            modifiedString = String.valueOf(array);

            myType obj3 = formString(modifiedString, currentIndex+1);
            if (obj3.isValid) return obj3;
        }


            return new myType(false,curString);

    }


}
