package domain;

import exception.ErrorMessage;

public class Height {
    private static final int MINIMUM_HEIGHT = 1;
    private final int height;

    public Height(int height){
        validateHeight(height);
        this.height = height;
    }

    private void validateHeight(int height){
        if (height < MINIMUM_HEIGHT){
            throw new IllegalArgumentException(ErrorMessage.HEIGHT_IS_BIGGER_THAN_0.getMessage());
        }
    }

    public int getHeight(){
        return height;
    }
}
