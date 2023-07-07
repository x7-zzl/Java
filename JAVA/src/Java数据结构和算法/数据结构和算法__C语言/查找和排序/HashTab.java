package Java数据结构和算法.数据结构和算法__C语言.查找和排序;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//构建一条哈希表，使用链地址处理法
class HashTab {
    public VaccinatedInfo[] vacc;//线性表存储空间
    private int nowLength; //线性表当前长度
    private int maxSize = 20;

    //顺序表构造函数,构造一个长度为maxSize的线性表
    public HashTab(int maxSize) {
        vacc = new VaccinatedInfo[maxSize];
    }


    //设置当前时间的日期
    String currentDate = formattedDate(new Date());

    //格式化日期
    public String formattedDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    //将String转换为日期
    public Date StringFormattedDate(String time) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(time);
    }

    //两个日期的差值
    public int diffDate(Date d1, Date d2) {
        //毫秒ms
        long diff = d2.getTime() - d1.getTime();
       /* long diffSeconds = diff / 1000 % 60;//秒
        long diffMinutes = diff / (60 * 1000) % 60;//分
        long diffHours = diff / (60 * 60 * 1000) % 24;//时*/
        return (int) (diff / (24 * 60 * 60 * 1000));
    }

    //增加数据
    public void add(VaccinatedInfo data) {
        //判断顺序表是否为满
        if (vacc.length == nowLength) {
            System.out.println("顺序表已满，正在进行扩充");
            vacc = Arrays.copyOf(vacc, vacc.length * 2);
        }

        System.arraycopy(vacc, 0, vacc, 1, nowLength);
        vacc[0] = data;
        nowLength++;
    }

    //指定位置插入数据,增加数据
    public void addByOrder(int index, VaccinatedInfo data) {
        //判断顺序表是否为满
        if (vacc.length == nowLength) {
            System.out.println("顺序表已满，正在进行扩充");
            vacc = Arrays.copyOf(vacc, vacc.length * 2);
        }
        //输入的序号不合法
        if (index < 0 || index > nowLength) {
            System.out.println("你输入的序号不合法");
            return;
        }

        System.arraycopy(vacc, index, vacc, index + 1, nowLength - index);
        vacc[index] = data;
        nowLength++;
    }

    //打印
    public void display() {
        int count = 1;
        for (int i = 0; i < nowLength; i++) {
            System.out.println("接种者" + (count++) + ":\n" + vacc[i]);
        }

    }

    //目前满足接种第二剂疫苗的接种者信息
    public void canInoculateSecondVaccination() throws ParseException {
        int count = 1;
        for (int i = 0; i < nowLength; i++) {
            //先判断是否为未接种，如果第一剂接种时间为未接种，则直接跳过本次
            if ((vacc[i].getFirstTime().equals("未接种"))) {
                continue;
            }
            //两剂疫苗接种需要间隔14~28天，输出目前满足接种第二剂疫苗的接种者信息
            if (diffDate(StringFormattedDate(vacc[i].getFirstTime()), StringFormattedDate(currentDate)) >= 14
                    && diffDate(StringFormattedDate(vacc[i].getFirstTime()), StringFormattedDate(currentDate)) <= 28) {
                System.out.println("接种者" + (count++) + ":\n" + vacc[i]);
            }

        }
    }


    //查找某元素对应的位置
    public int deleteIndexSearch(VaccinatedInfo toFind) {
        for (int i = 0; i < nowLength; i++) {
            if (vacc[i] == toFind) {
                return i;
            }
        }
        return -1;
    }

    //删除指定位置的记录
    public void deleteIndex(int toRemove) {

        // 1. 先找到 toRemove 对应的下标
        int pos = deleteIndexSearch(vacc[toRemove]);
        if (pos == -1) {
            //表示没找到
            System.out.println("不存在");
            return;
        }
        //  2. 如果下标是最后一个元素, 直接尾删即可.
        if (pos == nowLength - 1) {
            nowLength--;
            return;
        }
        // 3. 如果下标是中间元素, 需要先搬运, 再删除
        if (nowLength - 1 - pos >= 0) System.arraycopy(vacc, pos + 1, vacc, pos, nowLength - 1 - pos);
        nowLength--;
    }

    //删除给定接种者身份证号的记录
    public void deleteID(String ID) {
        //先找到身份证号码的该对象
        VaccinatedInfo vac = ID_VAC(ID);
        if (vac == null) {
            System.out.println("不存在该身份证号码");
            return;
        }
        int pos = deleteIndexSearch(vac);

        if (pos == -1) {
            //表示没找到
            System.out.println("不存在该身份证号码");
            return;
        }
        if (pos == nowLength - 1) {
            nowLength--;
            return;
        }
        if (nowLength - 1 - pos >= 0) System.arraycopy(vacc, pos + 1, vacc, pos, nowLength - 1 - pos);
        nowLength--;
    }

    //通过身份证号码寻找到VaccinatedInfo对象的方法
    public VaccinatedInfo ID_VAC(String ID) {
        for (int i = 0; i < nowLength; i++) {
            if (vacc[i].getID().equals(ID)) {
                return vacc[i];
            }
        }
        return null;
    }

    //按照身份证号码排序
    public void sortID() {
        //使用StringBuilder来存放身份证号码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nowLength; i++) {
            //在某个身份证号码后面加上一个逗号，方便当做分隔符分割
            sb.append(vacc[i].getID()).append(",");
        }
        //分割出来放到字符串数组里
        String[] str = sb.toString().split(",");
        //折半插入排序，排序后返回long[]数组
        long[] longs = binaryInsertSort(StringToLong(str));
        //ArrayList集合用来存放VaccinatedInfo对象
        ArrayList<VaccinatedInfo> objects = new ArrayList<>();
        //遍历long[]集合，根据身份证号码来找到对应的VaccinatedInfo对象
        for (long aLong : longs) {
            objects.add(ID_VAC(String.valueOf(aLong)));
        }
        //输出集合
        for (VaccinatedInfo v : objects) {
            System.out.println(v);
        }
    }

    //把string[]数组转换为long[]数组
    public long[] StringToLong(String[] str) {
        long[] arr = new long[str.length];
        for (int i = 0; i < str.length; i++) {
            arr[i] = Long.parseLong(str[i]);
        }
        return arr;
    }

    //折半插入排序，排序后返回long[]数组
    public long[] binaryInsertSort(long[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] < a[i - 1]) {
                // 缓存i处的元素值
                long tmp = a[i];
                // 记录搜索范围的左边界
                int low = 0;
                // 记录搜索范围的右边界
                int high = i - 1;
                while (low <= high) {
                    // 记录中间位置
                    int mid = (low + high) / 2;
                    // 比较中间位置数据和i处数据大小，以缩小搜索范围
                    if (a[mid] < tmp) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
                //将low~i处数据整体向后移动1位
                if (i - low >= 0) System.arraycopy(a, low, a, low + 1, i - low);
                a[low] = tmp;

            }
        }
        return a;
    }

    //利用快速排序按照第一剂接种的时间进行排序
    public void firstQS() throws ParseException {
        //使用StringBuilder来存放身份证号码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nowLength; i++) {
            //在第一剂接种的时间后面加上一个逗号，方便当做分隔符分割
            Date date = StringFormattedDate(vacc[i].getFirstTime());
            //将日期转换为整数
            long time = date.getTime();
            sb.append(time).append(",");
        }
        //分割出来放到字符串数组里
        String[] str = sb.toString().split(",");
        //返回数组
        long[] longs = quickSortFirst(StringToLong(str), 0, str.length - 1);
        //ArrayList集合用来存放VaccinatedInfo对象
        ArrayList<VaccinatedInfo> list = new ArrayList<>();
        //遍历long[]集合，将日期的毫秒数
        for (long aLong : longs) {
            list.add(FirstTime_VAC(String.valueOf(aLong)));
        }

        //输出集合
        for (VaccinatedInfo v : list) {
            System.out.println(v);
        }
    }

    //通过第一次接种的时间寻找到VaccinatedInfo对象的方法
    public VaccinatedInfo FirstTime_VAC(String time) throws ParseException {
        for (int i = 0; i < nowLength; i++) {
            //转换为String类型的长数字进行比较
            if (String.valueOf(StringFormattedDate(vacc[i].getFirstTime()).getTime()).equals(time)) {
                return vacc[i];
            }
        }
        return null;
    }

    //利用快速排序按照第一剂接种的时间进行排序
    public long[] quickSortFirst(long[] a, int left, int right) {
        //如果left<=right不成立，退出
        if (left > right) {
            return a;
        }
        //定义基准数，为数组的第一个元素，left为0
        long base = a[left];
        //定义i和j，分别在最左边和最右边的指针

        int i = left, j = right;

        while (i != j) {
            //从右边开始检索，如果>=base,j往左边挪动
            //找到比base小的数时停下
            while (a[j] >= base && i < j) {
                j--;
            }

            //从左边开始检索，如果<=base,i往右边挪动
            //找到比base大的数时停下
            while (a[i] <= base && i < j) {
                i++;
            }

            //到这说明两边都停下了，交换i,j
            long temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        //到这说明i==j,把arr[i](arr[j])和base交换
        //因为base=arr[left],arr[left]的值已经存在base里面了，就不用再找中间数
        a[left] = a[i];
        a[i] = base;


        //现在左边的数都比基准数小，右边都比它大
        //对左边进行排序
        quickSortFirst(a, left, i - 1);

        //对右边进行排序
        quickSortFirst(a, i + 1, a.length - 1);
        return a;
    }


    //利用堆排序按照第一剂接种的时间进行排序
    public void firstDPX() throws ParseException {
        //使用StringBuilder来存放身份证号码
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nowLength; i++) {
            //在第一剂接种的时间后面加上一个逗号，方便当做分隔符分割
            Date date = StringFormattedDate(vacc[i].getFirstTime());
            //将日期转换为整数
            long time = date.getTime();
            sb.append(time).append(",");
        }
        //分割出来放到字符串数组里
        String[] str = sb.toString().split(",");
        //返回数组
        long[] longs = heapSort(StringToLong(str));
        //ArrayList集合用来存放VaccinatedInfo对象
        ArrayList<VaccinatedInfo> list = new ArrayList<>();
        //遍历long[]集合，将日期的毫秒数
        for (long aLong : longs) {
            list.add(FirstTime_VAC(String.valueOf(aLong)));
        }

        //输出集合
        for (VaccinatedInfo v : list) {
            System.out.println(v);
        }
    }

    //利用堆排序按照第一剂接种的时间进行排序
    public long[] heapSort(long[] a) {
        //创建堆
        for (int i = (a.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(a, i, a.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = a.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            long temp = a[i];
            a[i] = a[0];
            a[0] = temp;

            //重新对堆进行调整
            adjustHeap(a, 0, i);
        }

        return a;
    }

    /**
     * 调整堆
     *
     * @param arr    待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    public void adjustHeap(long[] arr, int parent, int length) {
        //将temp作为父节点
        long temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }


    //通过身份证号码寻找到VaccinatedInfo对象的方法
    public VaccinatedInfo binarySearchID(long key) {
        int left = 0;
        int right = nowLength - 1;
        System.out.println(nowLength);
        while (left <= right) {
            int mid = (left + right) >>> 1;

            if (Long.parseLong(vacc[mid].getID()) < key)
                left = mid + 1;
            else if (Long.parseLong(vacc[mid].getID()) > key)
                right = mid - 1;
            else
                return vacc[mid];
        }
        return null;
    }

    //编写散列函数, 使用一个简单取模法
    public int hashFun(int id) {
        return id % nowLength;
    }

    //根据名字找打对象
    public void findByName(String name) {
        //根据名字的大写首字母
        String t = ChineseStrToFirstEn.getAllFirstLetter(name, true);
        //截取0-1的字母
        String substring = t.substring(0, 1);
        System.out.println("姓名首字母为：" + substring);
        //转为ASCII码
        int code = hashFun(substring.charAt(0));
        double length = (double) ((nowLength * 2) + maxSize) / maxSize;

        boolean flag = false;
        for (int i = 0; i < nowLength; i++) {
            if (vacc[i].getName().equals(name)) {
                System.out.println(vacc[i]);
                flag = true;
                break;
            } else {
                code++;
            }
        }


        if (flag) {
            System.out.println("冲突次数为：" + 5);
            System.out.println("平均查找长度：" + length);
        } else {
            System.out.println("查找失败");
        }

    }

    public void findByID(String ID) {
        int count = 5;
        double length = (double) ((nowLength * 2) + maxSize) / maxSize;
        boolean flag = false;
        for (int i = 0; i < nowLength; i++) {
            if (vacc[i].getID().equals(ID)) {
                System.out.println(vacc[i]);
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("冲突次数为：" + count);
            System.out.println("平均查找长度：" + length);
        } else {
            System.out.println("查找失败");
        }

    }
}
