fun main() {
    val firstMatrix = Matrix(arrayOf(intArrayOf(8,-5,10), intArrayOf(5,2,7)),2,3)
    val secondMatrix = Matrix(arrayOf(intArrayOf(4,1),intArrayOf(-4,15), intArrayOf(0,4)),3,2)
    val secondMatrix1 = Matrix(arrayOf(intArrayOf(9,5), intArrayOf(1,7), intArrayOf(5,4)),3,2)


    println("********** Addition **********")
    println("Matrix:1 ")
    print(secondMatrix1.toString())
    println("Matrix:2 ")
    print(secondMatrix.toString())
    val thirdMatrix = secondMatrix1 + secondMatrix
    println("Addition: \n$thirdMatrix")

    println("********** Subtraction **********")
    println("Matrix:1 ")
    print(secondMatrix1)
    println("Matrix:2 ")
    print(secondMatrix)
    val subtractMatrix = secondMatrix1 - secondMatrix
    println("Subtraction: \n$subtractMatrix")

    println("********** Multiplication **********")
    println("Matrix:1 ")
    print(secondMatrix1.toString())
    println("Matrix:2 ")
    print(secondMatrix.toString())
    val multiplication = firstMatrix * secondMatrix
    println("Multiplication: \n$multiplication")

}

class Matrix(matrix: Array<IntArray>,i:Int,j:Int){
    var i:Int
    var j:Int
    lateinit var matrix : Array<IntArray>
    init{
        this.i = i
        this.j = j
        this.matrix = matrix
    }
    operator fun plus(p: Matrix) : Matrix {
        val result = Array(i){IntArray(j)}
        for(row in 0 until i){
            for(column in 0 until j){
                result[row][column] = matrix[row][column] + p.matrix[row][column]
            }
        }
        return Matrix(result,i,j)
    }

    operator fun minus(p:Matrix):Matrix{
        val result = Array(i){IntArray(j)}
        for(row in 0 until i){
            for(column in 0 until j){
                result[row][column] = matrix[row][column] - p.matrix[row][column]
            }
        }
        return Matrix(result,i,j)
    }

    operator fun times(p:Matrix):Matrix{
        val result = Array(i){IntArray(i)}
        for(row in 0 until i){
            for(column in 0 until i){
                for(k in 0 until j){
                    result[row][column] += matrix[row][k] * p.matrix[k][column]
                }
            }
        }
        return Matrix(result,i,i)
    }

    override fun toString(): String {
        var msg : String = ""

        for(row in matrix.indices){
            for(column in 0 until matrix[row].size){
                msg += "${matrix[row][column]}   "
            }
            msg += "\n"
        }
        return msg
    }

}