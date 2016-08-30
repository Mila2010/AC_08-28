package nyc.c4q.Mila;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Millochka on 8/29/16.
 */
public class Student {

  private String mFirstName;
  private String mLastName;
  private int mIdNumber;
  private List<String>  mFavoriteFood ;

    public Student(String mfirstName, String mlastName, int midNumber, String mFavoriteFood){

        this.mFirstName = mfirstName;
        this.mLastName = mlastName;
        this.mIdNumber = midNumber;
        this.mFavoriteFood = new ArrayList<String>();
        this.mFavoriteFood.add(mFavoriteFood);

    }

    public Student(String mfirstName){
        this.mFirstName = mfirstName;
        mLastName = "";
        mIdNumber = 0;
        this.mFavoriteFood = new ArrayList<String>();
    }


    public Student(){
        mFirstName = "";
        mLastName = "";
        mIdNumber = 0;
        this.mFavoriteFood = new ArrayList<String>();
    }



    public String getmfirstName(){
        return mFirstName;
    }
    public String getmlastName(){
        return mLastName;
    }
    public int getmidNumber(){
        return mIdNumber;
    }

    public String getmFavoriteFood(int i){
        return mFavoriteFood.get(i);
    }

    public List<String> getmFavoriteFood(){
        return this.mFavoriteFood;
    }

    public void setmFirstName(String name){
        this.mFirstName = name;

    }

    public void setmLastName(String name){
        this.mLastName = name;

    }

    public void setmIdNumber(int idNumber){
        this.mIdNumber = idNumber;

    }
    public void setmFavoriteFood(String favoriteFood){
        mFavoriteFood.add(favoriteFood);
    }

}
