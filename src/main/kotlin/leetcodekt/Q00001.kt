package leetcodekt


class Soution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val sortedArray = nums.copyOf().sorted()

        var frontIdx = 0
        var rearIdx = nums.size - 1

        while (frontIdx < rearIdx) {
            val sum = sortedArray[frontIdx] + sortedArray[rearIdx]

            if (sum == target) {
                break
            } else if (sum < target) {
                ++frontIdx
            } else {
                --rearIdx
            }
        }

        val originIdxOfFront = nums.indexOf(sortedArray[frontIdx])
        val originIdxOfRear = nums.lastIndexOf(sortedArray[rearIdx])

        return intArrayOf(originIdxOfFront, originIdxOfRear)
    }
}



// 배열 복사하기 IntArray.copyOf()
// 배열 정렬하기 sort(), 내림차순 sortDescending()
// 배열 정렬후 리스트로 반환 sorted(), sortedDescending()

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
