package com.example.last.presentation.repository

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.last.data.user.GithubUserRepositoryFactory
import com.example.last.databinding.FragmentRepositoriesBinding
import com.example.last.presentation.App
import com.example.last.presentation.GithubRepositoryViewModel
import com.example.last.presentation.repository.adapter.RepositoriesAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class RepositoriesFragment : MvpAppCompatFragment(), RepositoriesView, RepositoriesAdapter.Delegate {

    companion object {
        private const val ARG_USER_LOGIN = "arg_user_login"

        fun newInstance(userId: String): Fragment =
            RepositoriesFragment().apply {
                arguments = bundleOf(ARG_USER_LOGIN to userId)
            }
    }

    private val userLogin: String by lazy {
        arguments?.getString(ARG_USER_LOGIN).orEmpty()
    }

    private val presenter: RepositoriesPresenter by moxyPresenter {
        RepositoriesPresenter(
            userLogin = userLogin,
            userRepository = GithubUserRepositoryFactory.create(),
            router = App.instance.router
        )
    }

    private var _binding: FragmentRepositoriesBinding? = null
    private val viewBinding: FragmentRepositoriesBinding
        get() {
            return _binding!!
        }

    private val repositoriesAdapter = RepositoriesAdapter(delegate = this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRepositoriesBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.rvRepository.adapter = repositoriesAdapter
    }

    override fun showRepositories(repositories: List<GithubRepositoryViewModel>) {
        repositoriesAdapter.submitList(repositories)
    }

    override fun showEmpty() {
        Toast.makeText(requireContext(), "Not found repositories", Toast.LENGTH_SHORT).show()
    }

    override fun showError(error: Throwable) {
        Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
    }

    override fun onRepositoryPicked(repository: GithubRepositoryViewModel) {
        presenter.displayRepository(repository)
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}