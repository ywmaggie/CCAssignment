/**
 * Created by zhangyuwei on 10/7/15.
 */
public class Solution09 {
    /*
        take 1~10 for example,
        locker 1 is open by pass 1,
        locker 2 is open by pass 1, close by pass 2
        locker 3 is open by pass 1, close by pass 3
        locker 4 is open by 1, close by 2, open by 4
        locker 5 open by 1, close by 5
        locker 6 open by 1, close 2, open 3, close 6
        locker 7 open 1, close 7
        locker 8 open 1, close 2, open 4, close 8
        locker 9 open 1, close 3, open 9
        locker 10 open 1, close 2, open 5, close 10

        That is, a locker is open only when it has ODD number of divisors, that is a square number.
        Prime numbers have divisors 1 and itself. Typical non-prime numbers like 6 have a pair of divisors 2 and 3.
        Only square numbers have ODD number of divisors, because the divisor number pair like 2 and 2 are the same.

        so we have 1,4,9,25,...,100 we have all together 10 lockers open.
     */
}
