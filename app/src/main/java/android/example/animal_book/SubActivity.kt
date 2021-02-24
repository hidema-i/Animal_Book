package android.example.animal_book

import android.example.animal_book.databinding.ActivitySubBinding
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding //ビューバインディング設定
    private lateinit var title: TitleFragment //タイトルプロパティを格納するために用意
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //ビューバインディング設定
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //ライオンボタンが押された時の処理
        binding.lionButton.setOnClickListener {
            //getSupport fragmentManagerメソッドでFragmentManagerクラスのインスタンスを取得
            supportFragmentManager.beginTransaction().apply {
                //FragmentTransactionクラスのreplaceメソッドでフラグメントを配置
                replace(R.id.container, LionFragment())
                //バックスタックを保存し、戻るボタンを押した時に1つ前に戻る
                addToBackStack(null)
                //commitメソッドを呼び出してフラグメントの操作を確定。注)：commitメソッドを使わないとトランザクションが終わらないので注意
                commit()
            }
        }
        binding.hippoButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, HippoFragment())
                addToBackStack(null)
                commit()
            }
        }
        binding.giraffe.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, GiraffeFragment())
                addToBackStack(null)
                commit()
            }
        }
        //フラグメントを設定して画面の上部に表示する
        title = TitleFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.titleFrame, title)
            commit()
        }
    }
    override fun onResume(){
        super.onResume()
        //タイトル用のフラグメントに文字列を表示
        title.setTitle("サブ画面")
    }
}