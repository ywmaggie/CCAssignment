/**
 * Created by zhangyuwei on 9/30/15.
 */


/*
    We use what is called external sort.
    I learnt the following from Wikipedia, and I will simply describe this algorithm in my own words.
    We keep getting data of the size of memory into memory and sort them, and then put back onto disk.
    After this, we have several chunks of sorted data.
    We pick the head of each sorted data and put them in the memory, leaving some space in the memory for output.
    We do n-merge and put result in the output. When the output is full, we write them back to memory.
    When we go to the end of any chunk of data, we move the next part of data in that chunk into memory.
    Finally, we will get all data sorted in disk.
 */