package com.example.last.presentation.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.last.data.user.GithubUserRepositoryFactory
import com.example.last.databinding.FragmentUsersBinding
import com.example.last.presentation.App
import com.example.last.presentation.BackButtonListener
import com.example.last.presentation.users.adapter.UsersRVAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UsersView, BackButtonListener {
    companion object {
        fun newInstance() = UsersFragment()
    }

    private val presenter: UsersPresenter by moxyPresenter {
        UsersPresenter(
            GithubUserRepositoryFactory.create(),
            App.instance.router
        )
    }
    var adapter: UsersRVAdapter? = null

    private var vb: FragmentUsersBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) =
        FragmentUsersBinding.inflate(inflater, container, false).also {
            vb = it
        }.root

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun init() {
        vb?.rvUsers?.layoutManager = LinearLayoutManager(context)
        adapter = UsersRVAdapter(presenter.usersListPresenter)
        vb?.rvUsers?.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
    }

    override fun showEmpty() {
        Toast.makeText(requireContext(), "Not found users", Toast.LENGTH_SHORT).show()
    }

    override fun backPressed() = presenter.backPressed()
}