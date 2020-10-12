import java.util.Scanner;
import java.util.*;
import java.lang.Math.*;
public class Question1{
    public static void main(String[] args){
        int n, m;
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine(); // So that next input is from next line
        String temp;
        String[] crops = new String[n];
        for (int i=0;i<n;i++){
            crops[i]=in.nextLine().trim();
        }
        System.out.println(replant(crops));
    }
    public static int replant(String[] crops){
        char crops_mat[][] = new char[crops.length][];
        for(int i = 0;i<crops.length;i++){
            crops_mat[i] = crops[i].toCharArray();

        }
        int n=crops.length;
        int m = crops_mat[0].length;
        char[] crop_types = new char[26];
        for(char ch = 'a';ch<'z';ch++){
            crop_types[ch-'a'] = ch;
        }
        return replant(crops_mat, 0, 0, n, m, 0, n*m, crop_types);
    }

    public static int replant(char[][] crops_mat, int curr_row, int curr_col, int n, int m, int curr_count, int minm_count, char[] crop_types){
        Set<Character> left_up = new HashSet<Character>();
        if(curr_row!=0){
            left_up.add(crops_mat[curr_row-1][curr_col]);
        }
        if(curr_col!=0){
            left_up.add(crops_mat[curr_row][curr_col-1]);
        }
        Set<Character> right_down = new HashSet<Character>();
        if(curr_row!=n-1){
            right_down.add(crops_mat[curr_row+1][curr_col]);
        }
        if(curr_col!=m-1){
            right_down.add(crops_mat[curr_row][curr_col+1]);
        }
        boolean present_left_up = false;
        if(left_up.contains(crops_mat[curr_row][curr_col])){
            present_left_up = true;
        }
        char[][] new_crops_mat = new char[n][m];
        if(right_down.contains(crops_mat[curr_row][curr_col]))
        {
            if(present_left_up)
            {
                for(int k=0; k<26; k++)
                {
                    if(!left_up.contains(crop_types[k]) && !right_down.contains(crop_types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_mat[i][j] = crops_mat[i][j];
                            }
                        }
                        new_crops_mat[curr_row][curr_col] = crop_types[k];
                        if(curr_col<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row, curr_col+1, n, m, curr_count+1, minm_count, crop_types));
                        }
                        else if(curr_row<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row+1, 0, n, m, curr_count+1, minm_count, crop_types));
                        }
                        else
                        {
                            return Math.min(curr_count+1, minm_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(curr_col<m-1)
                {
                    minm_count = Math.min(minm_count, replant(crops_mat, curr_row, curr_col+1, n, m, curr_count, minm_count, crop_types));
                }
                else if(curr_row<n-1)
                {
                    minm_count = Math.min(minm_count, replant(crops_mat, curr_row+1, 0, n, m, curr_count, minm_count, crop_types));
                }
                else
                {
                    return Math.min(curr_count, minm_count);
                }
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(crop_types[k]) && !right_down.contains(crop_types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0; j<m; j++)
                            {
                                new_crops_mat[i][j] = crops_mat[i][j];
                            }
                        }
                        new_crops_mat[curr_row][curr_col] = crop_types[k];
                        if(curr_col<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row, curr_col+1, n, m, curr_count+1, minm_count, crop_types));
                        }
                        else if(curr_row<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row+1, 0, n, m, curr_count+1, minm_count, crop_types));
                        }
                        else
                        {
                            return Math.min(curr_count+1, minm_count);
                        }
                        break;
                    }
                }

            }
        }
        else
        {
            if(present_left_up)
            {
                for(int k=0; k<26;k++)
                {
                    if(!left_up.contains(crop_types[k]) && !right_down.contains(crop_types[k]))
                    {
                        for(int i=0; i<n; i++)
                        {
                            for(int j=0;j<m;j++)
                            {
                                new_crops_mat[i][j] = crops_mat[i][j];
                            }
                        }
                        new_crops_mat[curr_row][curr_col] = crop_types[k];
                        if(curr_col<m-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row, curr_col+1, n, m, curr_count+1, minm_count, crop_types));
                        }
                        else if(curr_row<n-1)
                        {
                            minm_count = Math.min(minm_count, replant(new_crops_mat, curr_row+1, 0, n, m, curr_count+1, minm_count, crop_types));
                        }
                        else
                        {
                            return Math.min(curr_count+1, minm_count);
                        }
                        break;
                    }
                }
            }
            else
            {
                if(curr_col<m-1)
                {
                    minm_count = Math.min(minm_count, replant(crops_mat, curr_row, curr_col+1, n, m, curr_count, minm_count, crop_types));
                }
                else if(curr_row<n-1)
                {
                    minm_count = Math.min(minm_count, replant(crops_mat, curr_row+1, 0, n, m, curr_count, minm_count, crop_types));
                }
                else
                {
                    return Math.min(curr_count, minm_count);
                }
            }
        }
        return minm_count;
    }
}