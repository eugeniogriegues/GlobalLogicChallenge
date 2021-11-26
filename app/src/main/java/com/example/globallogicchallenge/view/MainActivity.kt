package com.example.globallogicchallenge.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.globallogicchallenge.databinding.ActivityMainBinding
import com.example.globallogicchallenge.model.Item
import com.example.globallogicchallenge.viewmodel.GlobalLogicViewModel

class MainActivity : AppCompatActivity() {


   /*  val listaParaTestear = listOf (    //  LISTA DE ITEMS PARA TESTEAR EL RECYCLERVIEW Y LA CONECTIVIDAD

         Item ("Macbook PRO", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis dapibus varius sem, eu ultricies urna condimentum a. Suspendisse aliquam mi vel orci viverra consectetur. Morbi at diam neque. Nam commodo risus sit amet mi hendrerit, sed facilisis quam tincidunt. Nulla facilisi. Nam commodo ultricies dignissim. In tempor sapien mattis, suscipit dolor at, semper odio. Proin interdum sapien sit amet nibh tincidunt, luctus congue nunc viverra. Proin pharetra neque vel orci porta, et pharetra turpis venenatis. Nam volutpat aliquet ante, nec ullamcorper felis semper eget. Vivamus posuere suscipit gravida. Nunc ut efficitur turpis.", "https://picsum.photos/100/100?image=0"),

         Item ("Duis dapibus varius sem, eu ultricies urna condimentum.", "In hac habitasse platea dictumst. Aliquam mi erat, fermentum non nisi non, congue dictum velit. Suspendisse hendrerit velit at vulputate suscipit. Nunc in erat vestibulum, lacinia neque vel, molestie arcu. Proin vestibulum sagittis mauris, eu consequat neque imperdiet non. Donec feugiat viverra quam, sit amet pulvinar justo accumsan sed. Praesent gravida eros in libero facilisis, quis molestie nisl interdum. Ut gravida vel felis quis rutrum. Mauris accumsan lacus et sem efficitur, in mattis sem lacinia. Suspendisse id nisi arcu. Maecenas at magna in nisl ornare gravida. Pellentesque vitae auctor sem.", "https://picsum.photos/200/200?image=1"),

         Item ("In hac habitasse platea dictumst", "Interdum et malesuada fames ac ante ipsum primis in faucibus. Ut pharetra cursus suscipit. Fusce consequat placerat sem ac imperdiet. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Curabitur gravida tempus leo eget hendrerit. Sed et libero id turpis consectetur eleifend ac vitae leo. Aenean mattis augue massa, eget euismod ipsum pellentesque nec. Quisque gravida dapibus nisl, sed laoreet eros lobortis quis.", "https://picsum.photos/300/300?image=2"),

         Item ("Laptop 4", "Maecenas ornare nisl non lacus viverra, at placerat mauris iaculis. Morbi convallis varius mi, luctus bibendum quam venenatis nec. Quisque facilisis hendrerit odio, id rhoncus metus tempor cursus. Suspendisse sagittis nisl eget efficitur varius. Integer efficitur faucibus faucibus. Cras mauris mauris, molestie non velit sed, fringilla porttitor felis. Sed et ultricies eros. Nam vulputate tincidunt augue vulputate tristique. Sed libero nibh, rhoncus sollicitudin velit non, efficitur dapibus risus. In id massa at justo condimentum lacinia. Pellentesque ut sapien a eros commodo bibendum lacinia non orci. Suspendisse non lacus non augue egestas suscipit. Vivamus blandit, metus ut porttitor rutrum, ipsum turpis sagittis nisl, vestibulum blandit eros ex convallis enim.", "https://picsum.photos/400/400?image=3"),

         Item ("Nam posuere purus pharetra leo accumsan, quis lacinia urna venenatis. Ut non volutpat libero. â‚¬", "Mauris eu congue lacus. Etiam vel feugiat neque, nec mollis arcu. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Donec bibendum facilisis felis vitae ultricies. Nam posuere purus pharetra leo accumsan, quis lacinia urna venenatis. Ut non volutpat libero. Proin maximus efficitur fringilla. Suspendisse interdum felis fringilla fermentum maximus.", "https://picsum.photos/500/500?image=4"),


 )  */


    private lateinit var binding: ActivityMainBinding

    private val globalLogicViewModel : GlobalLogicViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // iniciarRecyclerItems (listaParaTestear)


        globalLogicViewModel.globalLogicModel.observe(this, androidx.lifecycle.Observer {


            iniciarRecyclerItems(it)

        })



        globalLogicViewModel.obtenerListaItems()


    }


    private fun iniciarRecyclerItems (listaItems : List<Item>) {  //  METODO PARA INICIAR EL RECYCLERVIEW CON UNA LISTA DE OBJETOS ITEM

        val adapterItem = AdapterItemList(listaItems)

        val recyclerViewPhoto = binding.rvListado

        recyclerViewPhoto.layoutManager =
            StaggeredGridLayoutManager(
                1,
                StaggeredGridLayoutManager.VERTICAL
            )

        recyclerViewPhoto.adapter = adapterItem

    }





}
