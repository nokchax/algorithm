package leetcodekt


class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()

        nums.forEachIndexed { index, num ->
            if (map.containsKey(target - num)) {
                return intArrayOf(map[target - num]!!, index) // !!는  강제 not null 처리
            }
            map[num] = index
        }

        return intArrayOf()
    }
}



// 배열 복사하기 IntArray.copyOf()
// 배열 정렬하기 sort(), 내림차순 sortDescending()
// 배열 정렬후 리스트로 반환 sorted(), sortedDescending()
// !! 는 nullable 로 설정된 속성을 강제로 not null 로 바꿔줌
// type 에 ? 를 붙이면 null 이 가능한 변수임을 표시하는 것
// 변수?. (변수 뒤에 ?. 연산자) 변수가 null 이 아닐 때만 뒤에 함수가 실행, 그렇지 않다면 null 을 반환
// let 함수 변수가 not null 인 경우에만 지정된 구문을 실행시키는 let 함수
// let 함수를 사용하면 자신의 receiver 객를 람다식 내부로 넘겨줌
// let 함수 내부에서는 receiver 객체를 it 으로 받아서 표현

// another solution
/*
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, i ->
            if (map.contains(target - i)){
                return intArrayOf(map[target - i]!!, index) // !!의 의미는?
            }
            map[i] = index
        }
        return intArrayOf()
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val diffMap = mutableMapOf<Int, Int>()
        for(i in nums.indices) {
            val diff = target - nums[i]
            diffMap[nums[i]]?.let { return intArrayOf(i, it) } // ?.let , it
            diffMap[diff] = i
        }
        return intArrayOf()
    }
 */
