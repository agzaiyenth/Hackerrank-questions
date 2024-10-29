import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    static class ResultStorage {
        private final float[] values;
        private int index;
        
        public ResultStorage(float initialValue) {
            values = new float[100005]; 
            values[0] = initialValue;
            index = 1;
        }
        
        public void addValue(float value) {
            values[index++] = value;
        }
        
        public float getValue(int idx) {
            return values[idx];
        }
        
        public float getLastValue() {
            return values[index - 1];
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        while (testCases-- > 0) {
            String initialHex = scanner.next();
            float initialValue = Float.intBitsToFloat(Integer.parseUnsignedInt(initialHex, 16));
            ResultStorage resultStorage = new ResultStorage(initialValue);
            
            int lutCount = scanner.nextInt();
            List<float[]> lookupTables = new ArrayList<>();
            
            for (int i = 0; i < lutCount; i++) {
                int size = scanner.nextInt();
                float[] lut = new float[size];
                for (int j = 0; j < size; j++) {
                    String hex = scanner.next();
                    lut[j] = Float.intBitsToFloat(Integer.parseUnsignedInt(hex, 16));
                }
                lookupTables.add(lut);
            }
            
            int queries = scanner.nextInt();
            for (int i = 0; i < queries; i++) {
                String command = scanner.next();
                
                switch (command) {
                    case "L":
                        executeLutCommand(scanner, resultStorage, lookupTables);
                        break;
                    case "N":
                        executeNandCommand(scanner, resultStorage);
                        break;
                    case "F":
                        executeFmaCommand(scanner, resultStorage);
                        break;
                    case "C":
                        executeConstantCommand(scanner, resultStorage);
                        break;
                }
            }
            
            System.out.printf("%08x%n", Float.floatToRawIntBits(resultStorage.getLastValue()));
        }
    }
    
    private static void executeLutCommand(Scanner scanner, ResultStorage resultStorage, List<float[]> lookupTables) {
        int lutIndex = scanner.nextInt();
        int startBit = scanner.nextInt();
        int numBits = scanner.nextInt();
        
        int bits = Float.floatToRawIntBits(resultStorage.getValue(0));
        int mask = ((1 << numBits) - 1);
        int index = (bits >>> startBit) & mask;
        
        float result = lookupTables.get(lutIndex)[index];
        resultStorage.addValue(result);
    }
    
    private static void executeNandCommand(Scanner scanner, ResultStorage resultStorage) {
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        
        int val1 = Float.floatToRawIntBits(resultStorage.getValue(firstIndex));
        int val2 = Float.floatToRawIntBits(resultStorage.getValue(secondIndex));
        int result = ~(val1 & val2);
        
        resultStorage.addValue(Float.intBitsToFloat(result));
    }
    
    private static void executeFmaCommand(Scanner scanner, ResultStorage resultStorage) {
        int firstIndex = scanner.nextInt();
        int secondIndex = scanner.nextInt();
        int thirdIndex = scanner.nextInt();
        
        float a = resultStorage.getValue(firstIndex);
        float b = resultStorage.getValue(secondIndex);
        float c = resultStorage.getValue(thirdIndex);
        
        if (Float.isInfinite(a) || Float.isInfinite(b)) {
            if (a == 0.0f || b == 0.0f) {
                resultStorage.addValue(Float.NaN);
                return;
            }
            float product = a * b;
            if (Float.isInfinite(c) && Float.isInfinite(product)) {
                if ((c > 0) == (product > 0)) {
                    resultStorage.addValue(c);
                } else {
                    resultStorage.addValue(Float.NaN);
                }
                return;
            }
            resultStorage.addValue(product);
            return;
        }
        
        resultStorage.addValue(Math.fma(a, b, c));
    }
    
    private static void executeConstantCommand(Scanner scanner, ResultStorage resultStorage) {
        String hex = scanner.next();
        float value = Float.intBitsToFloat(Integer.parseUnsignedInt(hex, 16));
        resultStorage.addValue(value);
    }
}