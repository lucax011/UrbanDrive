import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.urbandrive.databinding.LoginMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: LoginMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Agora você pode acessar os elementos do layout através do objeto 'binding'
        // Exemplo: binding.textViewUsername.text = "Nome de usuário"
        // Certifique-se de substituir 'textViewUsername' pelo ID real do elemento no seu layout XML
    }
}
