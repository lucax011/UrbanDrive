import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.urbandrive.databinding.RegisterMainBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: RegisterMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = RegisterMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Agora você pode acessar os elementos do layout através do objeto 'binding'
        // Exemplo: binding.textViewEmail.text = "Email"
        // Certifique-se de substituir 'textViewEmail' pelo ID real do elemento no seu layout XML
    }
}
