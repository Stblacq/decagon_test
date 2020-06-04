package utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public  class PairSingletonResult {
    private  int pairs;
    private  int[] singletons;

}